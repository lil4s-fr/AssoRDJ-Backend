package fr.associationrdj.backend.back.demandeContact;

import fr.associationrdj.backend.back.typedemande.TypeDemande;
import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DemandeContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Utilisateur utilisateur;
    private String mail;
    private String message;
    @ManyToOne
    private TypeDemande typeDemande;
}
