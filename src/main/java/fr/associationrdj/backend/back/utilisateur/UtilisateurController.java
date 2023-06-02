package fr.associationrdj.backend.back.utilisateur;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    public UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("")
    public List<Utilisateur> findAll(){
        return utilisateurService.findAll();
    }
    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable("id") Long id){
        return utilisateurService.findById(id);
    }
    @PostMapping("")
    public Utilisateur save(@RequestBody Utilisateur utilisateur){
        return utilisateurService.save(utilisateur);
    }
    @PutMapping("")
    public Utilisateur update(@RequestBody Utilisateur utilisateur){
        return utilisateurService.update(utilisateur);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        utilisateurService.deleteById(id);
    }

}
