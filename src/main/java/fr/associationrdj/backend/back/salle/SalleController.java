package fr.associationrdj.backend.back.salle;

import fr.associationrdj.backend.back.salle.dto.SalleDTOFindAll;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/salles")
public class SalleController {
    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }
    @GetMapping("")
    public List<SalleDTOFindAll> findAll(){
        return salleService.findAll();
    }
    @GetMapping("/{id}")
    public Salle findById(@PathVariable("id") Long id){
        return salleService.findById(id);
    }
    @PostMapping("")
    public Salle save(@RequestBody Salle salle){
        return salleService.save(salle);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        salleService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Salle updateById(@PathVariable("id")Long id, @RequestBody Salle salle){
        return salleService.updateById(id, salle);
    }
}
