package fr.associationrdj.backend.back.utilisateur.dto;

import lombok.Data;

@Data
public class UtilisateurDTOFindAll {
    private Long id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String numeroAdherent;
    private String fichier;
}
