package fr.associationrdj.backend.back.evenement.dto;


import lombok.Data;
import java.util.Date;

@Data
public class EvenementDTOFindAll {

    private Long id;
    private String nom;
    private Date dateDebut;
    private String description;
    private String lieu;
}

