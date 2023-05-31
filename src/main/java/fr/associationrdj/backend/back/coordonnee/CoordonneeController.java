package fr.associationrdj.backend.back.coordonnee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    @GetMapping("")
    public Coordonnee findById(Long id){
        return coordonneeService.findById(id);
    }
    @PostMapping("")
    public Coordonnee save (Coordonnee coordonnee){
        return coordonneeService.save(coordonnee);
    }
    @PutMapping("/update")
    public Coordonnee update(Coordonnee coordonnee){
        return coordonneeService.update(coordonnee);
    }
    @DeleteMapping("/{id}")
    public void deleteById(Long id){
        coordonneeService.deleteById(id);
    }






}
