package fr.associationrdj.backend.back.article.dto;

import fr.associationrdj.backend.back.categorie.Categorie;
import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ArticleDTOFindAll {
    private Long id;
    private String titre;
    private String corps;
    private List<Categorie> categories;
    private LocalDate date_ecriture;
    private LocalDate date_modif;
    private List<Utilisateur> utilisateurs;
    private String fichier;
}
