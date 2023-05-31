package fr.associationrdj.backend.back.commentaire;

import fr.associationrdj.backend.back.evenement.Evenement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    public List<Commentaire> findAll(){
        return commentaireService.findAll();
    }

    public Commentaire findById(Long id){
        return commentaireService.findById(id);
    }

    public void create(Commentaire commentaire){
        commentaireService.save(commentaire);
    }

    public void save(Commentaire commentaire){
        commentaireService.save(commentaire);
    }

    public Commentaire update(Commentaire commentaire){
        return commentaireService.update(commentaire);
    }

    public void deleteById(Long id){
        commentaireService.deleteById(id);
    }

}
