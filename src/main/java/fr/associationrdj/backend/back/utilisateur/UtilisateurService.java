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

    public Utilisateur save (Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur update(Utilisateur utilisateur){
        Utilisateur utilisateurActuel = utilisateurRepository.findById(utilisateur.getId()).orElse(null);
        if (utilisateurActuel != null) {
            utilisateurActuel.setNom(utilisateur.getNom());
            utilisateurActuel.setPrenom(utilisateur.getPrenom());
            utilisateurActuel.setNumeroAdherent(utilisateur.getNumeroAdherent());
            utilisateurActuel.setPseudo(utilisateur.getPseudo());
            utilisateurActuel.setEmail(utilisateur.getEmail());
            utilisateurActuel.setNumeroTelephone(utilisateur.getNumeroTelephone());
            utilisateurActuel.setHashMotDePasse(utilisateur.getHashMotDePasse());
            utilisateurActuel.setCoordonnees(utilisateur.getCoordonnees());
            utilisateurActuel.setCategories(utilisateur.getCategories());
            return utilisateurRepository.save(utilisateur);
        } else {
            throw new RuntimeException("Utilisateur not found for id : " + utilisateur.getId());
        }
    }

    public void deleteById(Long id){
        utilisateurRepository.deleteById(id);
    }


}
