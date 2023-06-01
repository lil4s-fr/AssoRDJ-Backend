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

    public List<UtilisateurDTOFindAll> findAll(){
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().map(utilisateur -> objectMapper.convertValue(utilisateur, UtilisateurDTOFindAll.class) ).toList();
    }

    public UtilisateurDTOSansMDP findById(Long id){
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur not found"));
        return objectMapper.convertValue(utilisateur, UtilisateurDTOSansMDP.class);
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
