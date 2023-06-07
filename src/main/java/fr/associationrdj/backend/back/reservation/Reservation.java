package fr.associationrdj.backend.back.reservation;

import fr.associationrdj.backend.back.salle.Salle;
import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Salle salle;
    @OneToMany
    private List<Utilisateur> utilisateurs;
    private int participant;
    private boolean validation;
    private LocalDate date_reservation;
    private LocalDate date_evenement;
    private String description;
}
