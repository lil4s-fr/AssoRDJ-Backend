package fr.associationrdj.backend.back.evenement;

import fr.associationrdj.backend.back.categorie.Categorie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "evenements")
public class Evenement{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "evenement_categorie",
            joinColumns = @JoinColumn(name = "evenement_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categories;
    private String nom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateCreation;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateDebut;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFin;
    private String description;
    private String lieu;

}
