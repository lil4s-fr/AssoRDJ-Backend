package fr.associationrdj.backend.back.reservation.dto;

import fr.associationrdj.backend.back.salle.Salle;
import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ReservationDTOFindAll {

    private Long id;
    private Salle salle;
    private boolean validation;
    private LocalDate date_evenement;
    private String crenau;

}
