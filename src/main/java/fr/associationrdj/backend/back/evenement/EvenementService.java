package fr.associationrdj.backend.back.evenement;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.associationrdj.backend.back.evenement.dto.EvenementDTOFindAll;
import fr.associationrdj.backend.back.evenement.dto.EvenementDTONextEvents;

import fr.associationrdj.backend.back.evenement.dto.EvenementDTONextThreeEvents;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class EvenementService {

    private final EvenementRepository evenementRepository;
    private final ObjectMapper objectMapper;

    public EvenementService(EvenementRepository evenementRepository, ObjectMapper objectMapper) {
        this.evenementRepository = evenementRepository;
        this.objectMapper = objectMapper;
    }

    public List<EvenementDTOFindAll> findAll(){
        List<Evenement> evenements = evenementRepository.findAll();
        return evenements.stream().map(evenement -> objectMapper.convertValue(evenement, EvenementDTOFindAll.class)).toList();
    }

    public Evenement findById(Long id){
        return evenementRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evenement not found"));
    }

    public Evenement save (Evenement evenement){
        return evenementRepository.save(evenement);
    }

    public Evenement update(Evenement evenement){
        Evenement evenementActuel = evenementRepository.findById(evenement.getId()).orElse(null);
        if (evenementActuel != null) {
            evenementActuel.setNom(evenement.getNom());
            evenementActuel.setCategories(evenementActuel.getCategories());
            evenementActuel.setDateCreation(evenementActuel.getDateCreation());
            evenementActuel.setDescritpion(evenement.getDescritpion());
            evenementActuel.setDateFin(evenement.getDateFin());
            evenementActuel.setDateDebut(evenement.getDateDebut());
            return evenementRepository.save(evenement);
        } else {
            throw new RuntimeException("Evenement not found for id : " + evenement.getId());
        }
    }

    public void deleteById(Long id){
        evenementRepository.deleteById(id);
    }

    /**
     * Trie une liste d'évènements par ordre de date croissante.
     * @param evenements la liste d'évènements à trier
     * @return la liste d'évènements triée par date croissante
     */
    public List<Evenement> trierDatesCroissant(List<Evenement> evenements){
        evenements.sort(Comparator.comparing(Evenement::getDateDebut));
        return evenements;
    }

    /**
     * Filtre une liste d'évènements en ne conservant que les évènements postérieurs à la date actuelle.
     * @param evenements la liste d'évènements à filtrer
     * @return la liste des évènements futurs
     */
    public List<Evenement> findEvenementsFuturs(List<Evenement> evenements) {
        LocalDate dateActuelle = LocalDate.now();
        return evenements.stream()
                .filter(evenement -> evenement.getDateDebut().isAfter(dateActuelle))
                .collect(Collectors.toList());
    }

    /**
     * Retourne la liste des événements à venir.
     * @return la liste des événements à venir
     */
    public List<EvenementDTONextEvents> findAllPostLocalDate(){
        List<Evenement> evenements = evenementRepository.findAll();
        List<Evenement> evenementsFuturs = findEvenementsFuturs(evenements);
        List<Evenement> evenementsTries = trierDatesCroissant(evenementsFuturs);
        return evenementsTries.stream()
                .map(evenement -> objectMapper.convertValue(evenement, EvenementDTONextEvents.class))
                .collect(Collectors.toList());
    }

    /**
     * Retourne les prochains 3 prochains événements à venir .
     * @return la liste des 3 prochains événements à venir
     */
    public List<EvenementDTONextThreeEvents> findThreeNextEvents() {
        LocalDate dateActuelle = LocalDate.now();
        List<Evenement> evenements = evenementRepository.findAll();
        List<Evenement> evenementsFuturs = evenements.stream()
                .filter(evenement -> evenement.getDateDebut().isAfter(dateActuelle))
                .sorted(Comparator.comparing(Evenement::getDateDebut))
                .limit(3)
                .collect(Collectors.toList());
        return evenementsFuturs.stream()
                .map(evenement -> objectMapper.convertValue(evenement, EvenementDTONextThreeEvents.class))
                .collect(Collectors.toList());
    }
}
