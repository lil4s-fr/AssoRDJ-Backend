package fr.associationrdj.backend.back.commentaire;

import fr.associationrdj.backend.back.evenement.Evenement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping("")
    public List<Commentaire> findAll(){
        return commentaireService.findAll();
    }
    @GetMapping("/{id}")
    public Commentaire findById(Long id){
        return commentaireService.findById(id);
    }
    @PostMapping("")
    public Commentaire save(Commentaire commentaire){
        return commentaireService.save(commentaire);
    }
    @PutMapping("/update")
    public Commentaire update(Commentaire commentaire){
        return commentaireService.update(commentaire);
    }
    @DeleteMapping("/{id}")
    public void deleteById(Long id){
        commentaireService.deleteById(id);
    }

}
