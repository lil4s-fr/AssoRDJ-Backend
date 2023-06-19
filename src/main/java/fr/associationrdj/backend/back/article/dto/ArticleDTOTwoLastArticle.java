package fr.associationrdj.backend.back.article.dto;

import fr.associationrdj.backend.back.categorie.Categorie;
import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ArticleDTOTwoLastArticle {
    private Long id;
    private String titre;
    private List<Categorie> categories;
    private List<Utilisateur> utilisateurs;
    private LocalDate date_ecriture;
    private String corps;
    private LocalDate date_modif;
    private String like_dislike;//TODO
}
