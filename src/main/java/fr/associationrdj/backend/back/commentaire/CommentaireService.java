package fr.associationrdj.backend.back.commentaire;

import fr.associationrdj.backend.back.evenement.Evenement;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;

    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    public List<Commentaire> findAll(){
        return commentaireRepository.findAll();
    }

    public Commentaire findById(Long id){
        return commentaireRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evenement not found"));
    }

    public Commentaire save (Commentaire commentaire){
        return commentaireRepository.save(commentaire);
    }

    public Commentaire update(Commentaire commentaire){
        Commentaire commentaireActuel = commentaireRepository.findById(commentaire.getId()).orElse(null);
        if (commentaireActuel != null) {
            commentaireActuel.setCommentaire(commentaire.getCommentaire());
            commentaireActuel.setArticle(commentaire.getArticle());
            commentaireActuel.setUtilisateur(commentaire.getUtilisateur());
            commentaireActuel.setLike_dislike(commentaire.getLike_dislike());
            return commentaireRepository.save(commentaire);
        } else {
            throw new RuntimeException("Commentaire not found for id : " + commentaire.getId());
        }
    }

    public void deleteById(Long id){
        commentaireRepository.deleteById(id);
    }
}
