package fr.associationrdj.backend.back.article;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private Utilisateur utilisateur;
    private String titre;
    private String corps;
    private Date date_ecriture;
    private Date date_modif;
    private String like_dislike;


}
