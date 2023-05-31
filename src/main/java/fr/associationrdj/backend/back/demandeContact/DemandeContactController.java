package fr.associationrdj.backend.back.demandeContact;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update")
    public DemandeContact update(DemandeContact demandeContact){
        return demandeContactService.update(demandeContact);
    }
}
