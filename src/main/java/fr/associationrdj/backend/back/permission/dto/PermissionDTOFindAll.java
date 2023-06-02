package fr.associationrdj.backend.back.permission.dto;

import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import lombok.Data;

import java.util.List;

@Data
public class PermissionDTOFindAll {

    private Long id;
    private String statut;

}
