package fr.associationrdj.backend.back.permission;

import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String statut;
    @OneToMany
    private List<Utilisateur> utilisateurs;


}
