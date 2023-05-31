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
    public List<DemandeContact> findAll(){
        return demandeContactRepository.findAll();
    }
    public DemandeContact findById(Long id){
        return demandeContactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"DemandeContact Not-Found") {
        });
    }
    public DemandeContact save(DemandeContact demandeContact){
        return demandeContactRepository.save(demandeContact);
    }
    public void deleteById(Long id){
        demandeContactRepository.deleteById(id);
    }
    public DemandeContact update(DemandeContact demandeContact){
        DemandeContact demandeContactActuel = demandeContactRepository.findById(demandeContact.getId()).orElse(null);
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
