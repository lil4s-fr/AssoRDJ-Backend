package fr.associationrdj.backend.back.utilisateur;

import fr.associationrdj.backend.back.categorie.Categorie;
import fr.associationrdj.backend.back.coordonnee.Coordonnee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.Permission;

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
    private int numeroAdherent;
    private String pseudo;
    private String motDePasse;
    @OneToMany
    private Coordonnee coordonnees;
    @OneToOne
    private Permission permission;
    @ManyToMany
    @JoinTable(
            name = "utilisateur_categorie",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private Categorie categorie;

}
