package fr.associationrdj.backend.back.coordonnee;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coordonnees")
public class CoordonneeController {

    private final CoordonneeService coordonneeService;

    public CoordonneeController(CoordonneeService coordonneeService) {
        this.coordonneeService = coordonneeService;
    }

    public List<Coordonnee> findAll(){
        return coordonneeService.findAll();
    }

    public Coordonnee findById(Long id){
        return coordonneeService.findById(id);
    }

    public void create (Coordonnee coordonnee){
        coordonneeService.save(coordonnee);
    }

    public void save (Coordonnee coordonnee){
        coordonneeService.save(coordonnee);
    }

    public Coordonnee update(Coordonnee coordonnee){
        return coordonneeService.update(coordonnee);
    }

    public void deleteById(Long id){
        coordonneeService.deleteById(id);
    }






}
