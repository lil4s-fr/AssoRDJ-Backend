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
    /**
     * Retourne toutes les categories.
     * @return la liste des categories
     */
    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }

    /**
     * Retourne une categorie par son identifiant.
     * @param id l'identifiant de la categorie
     * @return la categorie correspondant à l'identifiant
     * @throws ResponseStatusException si la categorie n'est pas trouvé
     */
    public Categorie findById(Long id){
        return categorieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Categorie Not-Found"));
    }

    /**
     * Enregistre une nouvelle categorie.
     * @param categorie la categorie à enregistrer
     * @return la categorie enregistré
     */
    public Categorie save(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    /**
     * Supprime une categorie par son identifiant.
     * @param id l'identifiant de la categorie à supprimer
     */
    public void deleteById(Long id){
        categorieRepository.deleteById(id);
    }

    /**
     * Met à jour une categorie.
     * @param categorie la categorie à mettre à jour
     * @param id l'identifiant de la catégorie
     * @return la categorie mis à jour
     * @throws RuntimeException si la categorie n'est pas trouvé
     */
    public Categorie updateById(Long id, Categorie categorie){
        Categorie categorieActuel = categorieRepository.findById(id).orElse(null);
        if(categorie.getId() != null){
            categorieActuel.setNom(categorie.getNom());
            categorieActuel.setDescription(categorie.getDescription());
            categorieActuel.setReservations(categorie.getReservations());
            return categorieRepository.save(categorie);
        }else{
            throw new RuntimeException("Categorie Not-Found");
        }
    }
}
