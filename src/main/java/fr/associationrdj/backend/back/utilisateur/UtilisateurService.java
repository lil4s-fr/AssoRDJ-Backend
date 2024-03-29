package fr.associationrdj.backend.back.utilisateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.associationrdj.backend.back.utilisateur.dto.UtilisateurDTOFindAll;
import fr.associationrdj.backend.back.utilisateur.dto.UtilisateurDTOSansMDP;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final ObjectMapper objectMapper;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, ObjectMapper objectMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.objectMapper = objectMapper;
    }
    /**
     * Retourne tous les utilisateurs.
     * @return la liste des utilisateurs filtrer selon UtilisateurDTOFindAll
     */
    public List<UtilisateurDTOFindAll> findAll(){
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().map(utilisateur -> objectMapper.convertValue(utilisateur, UtilisateurDTOFindAll.class) ).toList();
    }

    /**
     * Retourne un utilisateur par son identifiant.
     * @param id l'identifiant de l'utilisateur
     * @return l'utilisateur correspondant à l'identifiant
     * @throws ResponseStatusException si l'utilisateur n'est pas trouvé
     */
    public UtilisateurDTOSansMDP findById(Long id){
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur not found"));
        return objectMapper.convertValue(utilisateur, UtilisateurDTOSansMDP.class);
    }

    /**
     * Enregistre un nouveau utilisateur.
     * @param utilisateur l'utilisateur à enregistrer
     * @return l'utilisateur enregistré
     */
    public Utilisateur save (Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    /**
     * Met à jour un utilisateur.
     * @param utilisateur l'utilisateur à mettre à jour
     * @param id l'identifiant de l'utilisateur
     * @return l'utilisateur mis à jour
     * @throws RuntimeException si l'utilisateur n'est pas trouvé
     */
    public Utilisateur updateById(Long id, Utilisateur utilisateur){
        Utilisateur utilisateurActuel = utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur not found for id: " + id));
        utilisateurActuel.setNom(utilisateur.getNom() == null ? utilisateurActuel.getNom() : utilisateur.getNom());
        utilisateurActuel.setPrenom(utilisateur.getPrenom() == null ? utilisateurActuel.getPrenom() : utilisateur.getPrenom());
        utilisateurActuel.setNumeroAdherent(utilisateur.getNumeroAdherent() == null ? utilisateurActuel.getNumeroAdherent() : utilisateur.getNumeroAdherent());
        utilisateurActuel.setPseudo(utilisateur.getPseudo() == null ? utilisateurActuel.getPseudo() : utilisateur.getPseudo());
        utilisateurActuel.setEmail(utilisateur.getEmail() == null ? utilisateurActuel.getEmail() : utilisateur.getEmail());
        utilisateurActuel.setNumeroTelephone(utilisateur.getNumeroTelephone() == null ? utilisateurActuel.getNumeroTelephone() : utilisateur.getNumeroTelephone());
        utilisateurActuel.setHashMotDePasse(utilisateur.getHashMotDePasse() == null ? utilisateurActuel.getHashMotDePasse() : utilisateur.getHashMotDePasse());
        utilisateurActuel.setCoordonnees(utilisateur.getCoordonnees() == null ? utilisateurActuel.getCoordonnees() : utilisateur.getCoordonnees());
        utilisateurActuel.setCategories(utilisateur.getCategories() == null ? utilisateurActuel.getCategories() : utilisateur.getCategories());
        utilisateurActuel.setPermission(utilisateur.getPermission() == null ? utilisateurActuel.getPermission() : utilisateur.getPermission());
        return utilisateurRepository.save(utilisateurActuel);
    }

    /**
     * Supprime un utilisateur par son identifiant.
     * @param id l'identifiant de l'utilisateur à supprimer
     */
    public void deleteById(Long id){
        utilisateurRepository.deleteById(id);
    }


}
