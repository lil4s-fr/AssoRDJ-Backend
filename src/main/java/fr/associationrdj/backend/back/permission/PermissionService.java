package fr.associationrdj.backend.back.permission;

import fr.associationrdj.backend.back.commentaire.Commentaire;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PermissionService {

    private PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public List<Permission> findAll(){
        return permissionRepository.findAll();
    }

    public Permission findById(Long id){
        return permissionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evenement not found"));
    }

    public void save (Permission permission){
        permissionRepository.save(permission);
    }

    public Permission update(Permission permission){
        Permission permission1Actuel = permissionRepository.findById(permission.getId()).orElse(null);
        if (permission1Actuel != null) {
            permission1Actuel.setUtilisateur(permission.getUtilisateur());
            permission1Actuel.setStatut(permission.getStatut());
            return permissionRepository.save(permission);
        } else {
            throw new RuntimeException("Permission not found for id : " + permission.getId());
        }
    }

    public void deleteById(Long id){
        permissionRepository.deleteById(id);
    }

}
