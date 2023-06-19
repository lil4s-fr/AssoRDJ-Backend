package fr.associationrdj.backend.back.article;

import fr.associationrdj.backend.back.categorie.Categorie;
import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "article_categorie",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categories;
    @ManyToMany
    @JoinTable(
            name = "article_utilisateur",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private List<Utilisateur> utilisateurs;
    private String titre;
    private String corps;
    private LocalDate date_ecriture = LocalDate.now();
    private LocalDate date_modif = LocalDate.now();
    private String like_dislike;//TODO
    private String fichier;


}
