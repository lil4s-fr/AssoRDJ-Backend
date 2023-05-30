package fr.associationrdj.backend.back.utilisateur;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findAll(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Long id){
        return utilisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Acteur not found"));
    }

    public void save (Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur update(Utilisateur utilisateur){
        Utilisateur utilisateurActuel = utilisateurRepository.findById(utilisateur.getId()).orElse(null);
        if (utilisateurActuel != null) {
            utilisateurActuel.setNom(utilisateur.getNom());
            utilisateurActuel.setPrenom(utilisateur.getPrenom());
            utilisateurActuel.setNumeroAdherent(utilisateur.getNumeroAdherent());
            utilisateurActuel.setPseudo(utilisateur.getPseudo());
            utilisateurActuel.setMotDePasse(utilisateur.getMotDePasse());
            utilisateurActuel.setCoordonnees(utilisateur.getCoordonnees());
            utilisateurActuel.setPermission(utilisateur.getPermission());
            utilisateurActuel.setCategorie(utilisateur.getCategorie());
            return utilisateurRepository.save(utilisateur);
        } else {
            throw new RuntimeException("Utilisateur not found for id : " + utilisateur.getId());
        }
    }

    public void deleteById(Long id){
        utilisateurRepository.deleteById(id);
    }


}
