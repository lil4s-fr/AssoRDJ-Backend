package fr.associationrdj.backend.back.permission;

import fr.associationrdj.backend.back.permission.dto.PermissionDTOFindAll;
import fr.associationrdj.backend.back.reservation.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("")
    public List<PermissionDTOFindAll> findAll(){
        return permissionService.findAll();
    }
    @GetMapping("/{id}")
    public Permission findById(@PathVariable("id") Long id){
        return permissionService.findById(id);
    }
    @PostMapping("")
    public void save(@RequestBody Permission permission){
         permissionService.save(permission);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id) { permissionService.deleteById(id); }
    @PutMapping("/{id}")
    public Permission updateById(@PathVariable("id") Long id, @RequestBody Permission permission ){
        return permissionService.updateById(id, permission);
    }

}
