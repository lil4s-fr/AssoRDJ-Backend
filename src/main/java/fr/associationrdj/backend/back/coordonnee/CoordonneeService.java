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

    public List<Coordonnee> findAll(){
        return coordonneeRepository.findAll();
    }

    public Coordonnee findById(Long id){
        return coordonneeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "coordonnee not found"));
    }

    public Coordonnee save (Coordonnee coordonnee){
        return coordonneeRepository.save(coordonnee);
    }

    public Coordonnee update(Coordonnee coordonnee){
        Coordonnee coordonneeActuel = coordonneeRepository.findById(coordonnee.getId()).orElse(null);
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

    public void deleteById(Long id){
        coordonneeRepository.deleteById(id);
    }
}
