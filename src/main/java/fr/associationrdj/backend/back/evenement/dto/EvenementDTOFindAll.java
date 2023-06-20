package fr.associationrdj.backend.back.evenement.dto;


import fr.associationrdj.backend.back.categorie.Categorie;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class EvenementDTOFindAll {

    private Long id;
    private List<Categorie> categories;
    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    private String lieu;
    private String fichier;
}

