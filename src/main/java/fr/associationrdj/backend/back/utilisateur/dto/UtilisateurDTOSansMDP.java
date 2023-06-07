package fr.associationrdj.backend.back.utilisateur.dto;

import fr.associationrdj.backend.back.categorie.Categorie;
import fr.associationrdj.backend.back.coordonnee.Coordonnee;
import fr.associationrdj.backend.back.permission.Permission;
import lombok.Data;

import java.util.List;

@Data
public class UtilisateurDTOSansMDP {

    private Long id;
    private String nom;
    private String prenom;
    private String numeroAdherent;
    private String pseudo;
    private String email;
    private String numeroTelephone;
    private List<Coordonnee> coordonnees;
    private Permission permission;
    private List<Categorie> categories;

}
