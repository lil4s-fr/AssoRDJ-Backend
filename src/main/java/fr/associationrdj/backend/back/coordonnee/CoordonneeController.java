package fr.associationrdj.backend.back.coordonnee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/coordonnees")
public class CoordonneeController {

    private final CoordonneeService coordonneeService;

    public CoordonneeController(CoordonneeService coordonneeService) {
        this.coordonneeService = coordonneeService;
    }
    @GetMapping("")
    public List<Coordonnee> findAll(){
        return coordonneeService.findAll();
    }
    @GetMapping("/{id}")
    public Coordonnee findById(@PathVariable("id") Long id){
        return coordonneeService.findById(id);
    }
    @PostMapping("")
    public Coordonnee save (@RequestBody Coordonnee coordonnee){
        return coordonneeService.save(coordonnee);
    }
    @PutMapping("/update")
    public Coordonnee update(@RequestBody Coordonnee coordonnee){
        return coordonneeService.update(coordonnee);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        coordonneeService.deleteById(id);
    }






}
