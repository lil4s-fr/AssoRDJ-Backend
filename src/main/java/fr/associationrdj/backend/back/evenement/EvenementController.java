package fr.associationrdj.backend.back.evenement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }
    @GetMapping("")
    public List<Evenement> findAll(){
        return evenementService.findAll();
    }
    @GetMapping("/{id}")
    public Evenement findById(@PathVariable("id") Long id){
        return evenementService.findById(id);
    }
    @PostMapping("")
    public Evenement save(@RequestBody Evenement evenement){
        return evenementService.save(evenement);
    }
    @PutMapping("/update")
    public Evenement update(@RequestBody Evenement utilisateur){
        return evenementService.update(utilisateur);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        evenementService.deleteById(id);
    }

}
