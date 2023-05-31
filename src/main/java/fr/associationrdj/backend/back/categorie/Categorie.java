package fr.associationrdj.backend.back.categorie;

import fr.associationrdj.backend.back.reservation.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(
        name = "categorie_reservation",
        joinColumns = @JoinColumn(name = "categorie_id"),
        inverseJoinColumns = @JoinColumn(name = "reservation_id"))
    private List<Reservation> reservations;
    private String nom;
    private String description;
}
