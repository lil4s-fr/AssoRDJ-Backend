package fr.associationrdj.backend.back.typedemande;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TypeDemandeService {

    private final TypeDemandeRepository typeDemandeRepository;

    public TypeDemandeService(TypeDemandeRepository typeDemandeRepository) {
        this.typeDemandeRepository = typeDemandeRepository;
    }
    /**
     * Retourne tous les types de demande.
     * @return la liste des types de demande.
     */
    public List<TypeDemande> findAll(){
        return typeDemandeRepository.findAll();
    }

    /**
     * Retourne un type de demande par son identifiant.
     * @param id l'identifiant du type de demande
     * @return le type de demande correspondant à l'identifiant
     * @throws ResponseStatusException si le type de demande n'est pas trouvé
     */
    public TypeDemande findById(Long id){
        return typeDemandeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
    }

    /**
     * Enregistre un nouveau type de demande.
     * @param typeDemande le type de demande à enregistrer
     * @return le type de demande enregistré
     */
    public TypeDemande save(TypeDemande typeDemande){
        return typeDemandeRepository.save(typeDemande);
    }

    /**
     * Supprime un type de demande par son identifiant.
     * @param id l'identifiant du type de demande à supprimer
     */
    public void deleteById(Long id){
        typeDemandeRepository.deleteById(id);
    }

    /**
     * Met à jour un type de demande.
     * @param typeDemande le type de demande à mettre à jour
     * @param id l'identifiant du type de demande
     * @return le type de demande mis à jour
     * @throws RuntimeException si le type de demande n'est pas trouvé
     */
    public TypeDemande updateById(Long id, TypeDemande typeDemande){
        TypeDemande typeDemandeActuel = typeDemandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Type de demande not found for id: " + id));
        typeDemandeActuel.setNom_type(typeDemande.getNom_type() == null ? typeDemandeActuel.getNom_type() : typeDemande.getNom_type());
        return typeDemandeRepository.save(typeDemandeActuel);
    }
}
