package fr.associationrdj.backend.back.utilisateur;

import fr.associationrdj.backend.back.utilisateur.dto.UtilisateurDTOFindAll;
import fr.associationrdj.backend.back.utilisateur.dto.UtilisateurDTOSansMDP;
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
    public List<UtilisateurDTOFindAll> findAll(){
        return utilisateurService.findAll();
    }
    @GetMapping("/{id}")
    public UtilisateurDTOSansMDP findById(@PathVariable("id") Long id){
        return utilisateurService.findById(id);
    }
    @PostMapping("")
    public Utilisateur save(@RequestBody Utilisateur utilisateur){
        return utilisateurService.save(utilisateur);
    }
    @PutMapping("/{id}")
    public Utilisateur updateById(@PathVariable("id")Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.updateById(id, utilisateur);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        utilisateurService.deleteById(id);
    }

}
