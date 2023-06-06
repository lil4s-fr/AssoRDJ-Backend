package fr.associationrdj.backend.back.coordonnee;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CoordonneeService {

    private final CoordonneeRepository coordonneeRepository;

    public CoordonneeService(CoordonneeRepository coordonneeRepository) {
        this.coordonneeRepository = coordonneeRepository;
    }
    /**
     * Retourne toutes les coordonnées.
     * @return la liste des coordonnées
     */
    public List<Coordonnee> findAll(){
        return coordonneeRepository.findAll();
    }

    /**
     * Retourne une coordonnee par son identifiant.
     * @param id l'identifiant de la coordonnee
     * @return la coordonnee correspondant à l'identifiant
     * @throws ResponseStatusException si la coordonnee n'est pas trouvé
     */
    public Coordonnee findById(Long id){
        return coordonneeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "coordonnee not found"));
    }

    /**
     * Enregistre une nouvelle coordonnee.
     * @param coordonnee la coordonnee à enregistrer
     * @return la coordonnee enregistré
     */
    public Coordonnee save (Coordonnee coordonnee){
        return coordonneeRepository.save(coordonnee);
    }

    /**
     * Met à jour une coordonnee.
     * @param coordonnee la coordonnee à mettre à jour
     * @param id l'identifiant de la coordonnee
     * @return la coordonnee mis à jour
     * @throws RuntimeException si la coordonnee n'est pas trouvé
     */
    public Coordonnee updateById(Long id, Coordonnee coordonnee){
        Coordonnee coordonneeActuel = coordonneeRepository.findById(id).orElse(null);
        if (coordonneeActuel != null) {
            coordonneeActuel.setNumeroRue(coordonnee.getNumeroRue());
            coordonneeActuel.setRue(coordonnee.getRue());
            coordonneeActuel.setComplementAdresse(coordonnee.getComplementAdresse());
            coordonneeActuel.setCodePostal(coordonnee.getCodePostal());
            coordonneeActuel.setVille(coordonnee.getVille());
            return coordonneeRepository.save(coordonnee);
        } else {
            throw new RuntimeException("Coordonnées not found for id : " + coordonnee.getId());
        }
    }

    /**
     * Supprime une coordonnee par son identifiant.
     * @param id l'identifiant de la coordonnee à supprimer
     */
    public void deleteById(Long id){
        coordonneeRepository.deleteById(id);
    }
}
