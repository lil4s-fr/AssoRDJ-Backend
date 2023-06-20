package fr.associationrdj.backend.back.evenement;

import fr.associationrdj.backend.back.article.dto.UUIDDto;
import fr.associationrdj.backend.back.evenement.dto.EvenementDTOFindAll;
import fr.associationrdj.backend.back.evenement.dto.EvenementDTONextEvents;
import fr.associationrdj.backend.back.evenement.dto.EvenementDTONextTwoEvents;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }
    @GetMapping("")
    public List<EvenementDTOFindAll> findAll(){
        return evenementService.findAll();
    }
    @GetMapping("/{id}")
    public Evenement findById(@PathVariable("id") Long id){
        return evenementService.findById(id);
    }
    @PostMapping("")
    public Evenement save(@RequestBody Evenement evenement){
        return evenementService.save(evenement);
    }
    @PutMapping("/{id}")
    public Evenement updateById(@PathVariable("id")Long id, @RequestBody Evenement utilisateur){
        return evenementService.updateById(id, utilisateur);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        evenementService.deleteById(id);
    }
    @GetMapping("/postlocaldate")
    public List<EvenementDTONextEvents> findAllPostLocalDate(){
        return evenementService.findAllPostLocalDate();
    }
    @GetMapping("/twonextevents")
    public List<EvenementDTONextTwoEvents> findTwoNextEvents(){ return evenementService.findTwoNextEvents();}

    @PostMapping("/img")
    public UUIDDto saveImage(@RequestParam("img") MultipartFile file)throws IOException {
        return new UUIDDto(evenementService.saveImage(file));
    }
    @GetMapping("/img/{id}")
    public FileSystemResource getImage(@PathVariable("id") String id) {
        return evenementService.getImage(id);
    }
}
