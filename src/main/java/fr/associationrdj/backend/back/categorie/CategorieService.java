package fr.associationrdj.backend.back.categorie;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }
    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }
    public Categorie findById(Long id){
        return categorieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Categorie Not-Found"));
    }
   public Categorie save(Categorie categorie){
        return categorieRepository.save(categorie);
    }
    public void deleteById(Long id){
        categorieRepository.deleteById(id);
    }
    public Categorie update(Categorie categorie){
        Categorie categorieActuel = categorieRepository.findById(categorie.getId()).orElse(null);
        if(categorie.getId() != null){
            categorieActuel.setNom(categorie.getNom());
            categorieActuel.setDescription(categorie.getDescription());
            categorieActuel.setReservation(categorie.getReservation());
            return categorieRepository.save(categorie);
        }else{
            throw new RuntimeException("Categorie Not-Found");
        }
    }
}
