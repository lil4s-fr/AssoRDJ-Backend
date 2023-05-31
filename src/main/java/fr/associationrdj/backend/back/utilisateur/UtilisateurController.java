package fr.associationrdj.backend.back.utilisateur;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    public UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public List<Utilisateur> findAll(){
        return utilisateurService.findAll();
    }

    public Utilisateur findById(Long id){
        return utilisateurService.findById(id);
    }

    public void create(Utilisateur utilisateur){
        utilisateurService.save(utilisateur);
    }

    public void save(Utilisateur utilisateur){
        utilisateurService.save(utilisateur);
    }

    public Utilisateur update(Utilisateur utilisateur){
        return utilisateurService.update(utilisateur);
    }

    public void deleteById(Long id){
        utilisateurService.deleteById(id);
    }

}
