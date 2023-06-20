package fr.associationrdj.backend.back.evenement.dto;

import fr.associationrdj.backend.back.categorie.Categorie;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EvenementDTONextThreeEvents {


    private Long id;
    private List<Categorie> categories;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String descritpion;
    private String lieu;
    private String fichier;
}
