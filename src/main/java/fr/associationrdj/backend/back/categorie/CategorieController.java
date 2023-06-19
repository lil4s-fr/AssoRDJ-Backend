package fr.associationrdj.backend.back.categorie;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }
    @GetMapping("")
    public List<Categorie> findAll(){
        return categorieService.findAll();
    }
    @GetMapping("/{id}")
    public Categorie findById(@PathVariable("id") Long id){
        return categorieService.findById(id);
    }
    @PostMapping("")
    public Categorie save(@RequestBody Categorie categorie){
        return categorieService.save(categorie);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        categorieService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Categorie updateById(@PathVariable("id")Long id, @RequestBody Categorie categorie){
        return categorieService.updateById(id, categorie);
    }
}
