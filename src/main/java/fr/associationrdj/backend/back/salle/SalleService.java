package fr.associationrdj.backend.back.salle;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }
    public List<Salle> findAll(){
        return salleRepository.findAll();
    }
    public Salle findById(Long id){
        return salleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Salle Not-Found") {
        });
    }
    public Salle save(Salle salle){
        return salleRepository.save(salle);
    }
    public void deleteById(Long id){
        salleRepository.deleteById(id);
    }
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
