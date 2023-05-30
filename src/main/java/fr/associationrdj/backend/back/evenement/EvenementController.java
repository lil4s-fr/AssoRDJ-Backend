package fr.associationrdj.backend.back.evenement;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    public List<Evenement> findAll(){
        return evenementService.findAll();
    }

    public Evenement findById(Long id){
        return evenementService.findById(id);
    }

    public void create(Evenement evenement){
        evenementService.save(evenement);
    }

    public void save(Evenement evenement){
        evenementService.save(evenement);
    }

    public Evenement update(Evenement utilisateur){
        return evenementService.update(utilisateur);
    }

    public void deleteById(Long id){
        evenementService.deleteById(id);
    }

}
