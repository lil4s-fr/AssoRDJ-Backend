package fr.associationrdj.backend.back.commentaire;

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
    /**
     * Retourne tous les commentaires.
     * @return la liste des commentaires
     */
    public List<Commentaire> findAll(){
        return commentaireRepository.findAll();
    }

    /**
     * Retourne un commantaire par son identifiant.
     * @param id l'identifiant du commentaire
     * @return le commentaire correspondant à l'identifiant
     * @throws ResponseStatusException si le commentaire n'est pas trouvé
     */
    public Commentaire findById(Long id){
        return commentaireRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evenement not found"));
    }

    /**
     * Enregistre un nouveau commentaire.
     * @param commentaire le commentaire à enregistrer
     * @return le commentaire enregistré
     */
    public Commentaire save (Commentaire commentaire){
        return commentaireRepository.save(commentaire);
    }

    /**
     * Met à jour un commentaire.
     * @param commentaire le commentaire à mettre à jour
     * @return le commentaire mis à jour
     * @throws RuntimeException si le commentaire n'est pas trouvé
     */
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

    /**
     * Supprime un commentaire par son identifiant.
     * @param id l'identifiant du commentaire à supprimer
     */
    public void deleteById(Long id){
        commentaireRepository.deleteById(id);
    }
}
