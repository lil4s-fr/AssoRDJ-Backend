package fr.associationrdj.backend.back.utilisateur;

import fr.associationrdj.backend.back.categorie.Categorie;
import fr.associationrdj.backend.back.coordonnee.Coordonnee;
import fr.associationrdj.backend.back.permission.Permission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String numeroAdherent;
    private String pseudo;
    private String email;
    private String numeroTelephone;
    private String hashMotDePasse;
    @OneToMany
    private List<Coordonnee> coordonnees;
    @ManyToOne
    private Permission permission;
    @ManyToMany
    @JoinTable(
            name = "utilisateur_categorie",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categories;

}
