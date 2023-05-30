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
    @ManyToOne
    private Coordonnee coordonnees;
    private Permission permission;
    @ManyToMany
    private Categorie categorie;

}
