package fr.associationrdj.backend.back.auth;

import fr.associationrdj.backend.back.utilisateur.Utilisateur;
import fr.associationrdj.backend.back.utilisateur.UtilisateurRepository;
import fr.associationrdj.backend.back.utilisateur.dto.UtilisateurDTOSansMDP;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserDetailService implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public JwtUserDetailService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    public UserDetails loadUserByUsername (String pseudo) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByPseudo(pseudo);
        if (utilisateur == null){
            System.out.println("Aucun utilisateur trouvé pour le nom"+pseudo);
            throw new UsernameNotFoundException("Aucun utilisateur trouvé pour le nom"+pseudo);
        }
        return new User(utilisateur.getPseudo(), utilisateur.getHashMotDePasse(), List.of());
    }

    public Utilisateur save (Utilisateur utilisateur){
        utilisateur.setHashMotDePasse(passwordEncoder.encode(utilisateur.getHashMotDePasse()));

        return utilisateurRepository.save(utilisateur);
    }



}
