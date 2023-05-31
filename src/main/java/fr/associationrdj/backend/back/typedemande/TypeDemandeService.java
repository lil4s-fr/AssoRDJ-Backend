package fr.associationrdj.backend.back.typedemande;

import fr.associationrdj.backend.back.reservation.Reservation;
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

    public List<TypeDemande> findAll(){
        return typeDemandeRepository.findAll();
    }
    public TypeDemande findById(Long id){
        return typeDemandeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
    }
    public TypeDemande save(TypeDemande typeDemande){
        return typeDemandeRepository.save(typeDemande);
    }
    public void deleteById(Long id){
        typeDemandeRepository.deleteById(id);
    }
    public TypeDemande update(TypeDemande typeDemande){
        TypeDemande typeDemandeActuel = typeDemandeRepository.findById(typeDemande.getId()).orElse(null);
        if (typeDemandeActuel != null){
            typeDemandeActuel.setNom_type(typeDemande.getNom_type());
            return typeDemandeRepository.save(typeDemande);
        }else {
            throw new RuntimeException("Reservation not found for id : ");
        }
    }
}
