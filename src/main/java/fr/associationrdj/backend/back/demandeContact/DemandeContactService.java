package fr.associationrdj.backend.back.demandeContact;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DemandeContactService {
    private final DemandeContactRepository demandeContactRepository;

    public DemandeContactService(DemandeContactRepository demandeContactRepository) {
        this.demandeContactRepository = demandeContactRepository;
    }
    /**
     * Retourne toutes les demandes de contact.
     * @return la liste des demande de contact.
     */
    public List<DemandeContact> findAll(){
        return demandeContactRepository.findAll();
    }

    /**
     * Retourne une demande de contact par son identifiant.
     * @param id l'identifiant de la demande de contact
     * @return la demande de contact correspondant à l'identifiant
     * @throws ResponseStatusException si la demande de contact n'est pas trouvé
     */
    public DemandeContact findById(Long id){
        return demandeContactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"DemandeContact Not-Found") {
        });
    }

    /**
     * Enregistre une nouvelle demande de contact.
     * @param demandeContact la demande de contact à enregistrer
     * @return la demande de contact enregistré
     */
    public DemandeContact save(DemandeContact demandeContact){
        return demandeContactRepository.save(demandeContact);
    }

    /**
     * Supprime une demande de contact par son identifiant.
     * @param id l'identifiant de la demande de contact à supprimer
     */
    public void deleteById(Long id){
        demandeContactRepository.deleteById(id);
    }

    /**
     * Met à jour une demande de contact.
     * @param demandeContact la demande de contact à mettre à jour
     * @param id l'identifiant de la demande de contact
     * @return la demande de contact mis à jour
     * @throws RuntimeException si la demande de contact n'est pas trouvé
     */
    public DemandeContact updateById(Long id, DemandeContact demandeContact){
        DemandeContact demandeContactActuel = demandeContactRepository.findById(id).orElse(null);
        if (demandeContact.getId() != null){
            demandeContactActuel.setUtilisateur(demandeContact.getUtilisateur());
            demandeContactActuel.setTypeDemande(demandeContact.getTypeDemande());
            demandeContactActuel.setMail(demandeContact.getMail());
            demandeContactActuel.setMessage(demandeContact.getMessage());
            return demandeContactRepository.save(demandeContact);
        }else {
            throw new RuntimeException("DemandeContact Not Found");
        }
    }
}
