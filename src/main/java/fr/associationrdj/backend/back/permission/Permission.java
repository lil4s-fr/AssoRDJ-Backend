package fr.associationrdj.backend.back.permission;

import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tables")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Utilisateur utilisateur;
    private String statut;


}
