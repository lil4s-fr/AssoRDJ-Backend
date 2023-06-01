package fr.associationrdj.backend.back.coordonnee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "coordonnees")
public class Coordonnee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroRue;
    private String rue;
    private String complementAdresse;
    private int codePostal;
    private String ville;
}
