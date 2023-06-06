package fr.associationrdj.backend.back.article.dto;

import fr.associationrdj.backend.back.categorie.Categorie;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ArticleDTOFindAll {
    private Long id;
    private String nom;
    private List<Categorie> categories;
    private LocalDate date_ecriture;
}
