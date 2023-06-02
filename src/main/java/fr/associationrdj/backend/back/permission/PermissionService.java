package fr.associationrdj.backend.back.permission;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.associationrdj.backend.back.permission.dto.PermissionDTOFindAll;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final ObjectMapper objectMapper;

    public PermissionService(PermissionRepository permissionRepository, ObjectMapper objectMapper) {
        this.permissionRepository = permissionRepository;
        this.objectMapper = objectMapper;
    }

    public List<PermissionDTOFindAll> findAll(){
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permission -> objectMapper.convertValue(permission, PermissionDTOFindAll.class)).toList();
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
            permission1Actuel.setUtilisateurs(permission.getUtilisateurs());
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
