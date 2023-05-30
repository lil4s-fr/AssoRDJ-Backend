package fr.associationrdj.backend.back.utilisateur;

import jakarta.persistence.*;
import jdk.jfr.Category;
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
    private Coordonnees coordonnees;
    private Permission permission;
    private Categorie categorie;






}
