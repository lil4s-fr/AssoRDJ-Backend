package fr.associationrdj.backend.back.salle;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.associationrdj.backend.back.salle.dto.SalleDTOFindAll;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;
    private final ObjectMapper objectMapper;

    public SalleService(SalleRepository salleRepository, ObjectMapper objectMapper) {
        this.salleRepository = salleRepository;
        this.objectMapper = objectMapper;
    }
    /**
     * Retourne toutes les salles.
     * @return la liste des salles filtrer selon SalleDTOFindAll
     */
    public List<SalleDTOFindAll> findAll(){
        List<Salle> salles = salleRepository.findAll();
        return salles.stream().map(salle -> objectMapper.convertValue(salle, SalleDTOFindAll.class) ).toList();
    }

    /**
     * Retourne une salle par son identifiant.
     * @param id l'identifiant de la salle
     * @return la salle correspondant à l'identifiant
     * @throws ResponseStatusException si la salle n'est pas trouvé
     */
    public Salle findById(Long id){
        return salleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Salle Not-Found") {
        });
    }

    /**
     * Enregistre une nouvelle salle.
     * @param salle la salle à enregistrer
     * @return la salle enregistré
     */
    public Salle save(Salle salle){
        return salleRepository.save(salle);
    }

    /**
     * Supprime une salle par son identifiant.
     * @param id l'identifiant de la salle à supprimer
     */
    public void deleteById(Long id){
        salleRepository.deleteById(id);
    }

    /**
     * Met à jour une salle.
     * @param salle la salle à mettre à jour
     * @return la salle mis à jour
     * @throws RuntimeException si la salle n'est pas trouvé
     */
    public Salle update(Salle salle){
        Salle salleActuel = salleRepository.findById(salle.getId()).orElse(null);
        if (salle.getId() != null){
            salleActuel.setNom(salle.getNom());
            salleActuel.setCapacite(salle.getCapacite());
            salleActuel.setLieu(salle.getLieu());
            salleActuel.setAcces_pmr(salle.isAcces_pmr());
            return salleRepository.save(salle);
        }else {
            throw new RuntimeException("Salle Not-Found");
        }
    }
}
