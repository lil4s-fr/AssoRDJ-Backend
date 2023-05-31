package fr.associationrdj.backend.back.commentaire;

import fr.associationrdj.backend.back.article.Article;
import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "commentaires")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Utilisateur utilisateur;
    private Article article;
    private String commentaire;
    private String like_dislike;


}
