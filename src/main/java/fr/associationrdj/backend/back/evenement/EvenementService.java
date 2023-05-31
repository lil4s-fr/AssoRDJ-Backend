package fr.associationrdj.backend.back.evenement;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;

    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public List<Evenement> findAll(){
        return evenementRepository.findAll();
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

}
