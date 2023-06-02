package fr.associationrdj.backend.back.evenement.dto;

import fr.associationrdj.backend.back.categorie.Categorie;

import java.util.Date;
import java.util.List;

public class EvenementDTOFirstThreeValues {


    private Long id;
    private List<Categorie> categories;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String descritpion;
}
