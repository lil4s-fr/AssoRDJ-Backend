package fr.associationrdj.backend.back.typedemande;

import fr.associationrdj.backend.back.reservation.Reservation;
import org.springframework.web.bind.annotation.*;

import java.security.Permission;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typedemandes")
public class TypeDemandeController {

    private TypeDemandeService typeDemandeService;

    public TypeDemandeController(TypeDemandeService typeDemandeService) {
        this.typeDemandeService = typeDemandeService;
    }

    @GetMapping("")
    public List<TypeDemande> findAll(){
        return typeDemandeService.findAll();
    }
    @GetMapping("/{id}")
    public TypeDemande findById(@PathVariable("id") Long id){
        return typeDemandeService.findById(id);
    }
    @PostMapping("")
    public TypeDemande save(@RequestBody TypeDemande typeDemande){
        return typeDemandeService.save(typeDemande);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        typeDemandeService.deleteById(id);
    }
    @PutMapping("/{id}")
    public TypeDemande updateById(@PathVariable("id")Long id, @RequestBody TypeDemande typeDemande){
        return typeDemandeService.updateById(id, typeDemande);
    }

}
