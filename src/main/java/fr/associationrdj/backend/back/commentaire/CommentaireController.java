package fr.associationrdj.backend.back.commentaire;

import fr.associationrdj.backend.back.evenement.Evenement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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
    public Commentaire findById(@PathVariable("id") Long id){
        return commentaireService.findById(id);
    }
    @PostMapping("")
    public Commentaire save(@RequestBody Commentaire commentaire){
        return commentaireService.save(commentaire);
    }
    @PutMapping("/{id}")
    public Commentaire updateById(@PathVariable("id")Long id, @RequestBody Commentaire commentaire){
        return commentaireService.updateById(id, commentaire);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        commentaireService.deleteById(id);
    }

}
