package fr.associationrdj.backend.back.demandeContact;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contacts")
public class DemandeContactController {
    private final DemandeContactService demandeContactService;

    public DemandeContactController(DemandeContactService demandeContactService) {
        this.demandeContactService = demandeContactService;
    }
    @GetMapping("")
    public List<DemandeContact> findAll(){
        return demandeContactService.findAll();
    }
    @GetMapping("/{id}")
    public DemandeContact findById(@PathVariable("id") Long id){
        return demandeContactService.findById(id);
    }
    @PostMapping("")
    public DemandeContact save(@RequestBody DemandeContact demandeContact){
        return demandeContactService.save(demandeContact);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        demandeContactService.deleteById(id);
    }
    @PutMapping("/{id}")
    public DemandeContact updateById(@PathVariable("id")Long id, @RequestBody DemandeContact demandeContact){
        return demandeContactService.updateById(id, demandeContact);
    }
}
