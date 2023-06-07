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
    /**
     * Retourne toutes les permissions.
     * @return la liste des permissions filtrer selon PermissionDTOFindAll
     */
    public List<PermissionDTOFindAll> findAll(){
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permission -> objectMapper.convertValue(permission, PermissionDTOFindAll.class)).toList();
    }

    /**
     * Retourne une permission par son identifiant.
     * @param id l'identifiant de la permission
     * @return la permission correspondant à l'identifiant
     * @throws ResponseStatusException si la permission n'est pas trouvé
     */
    public Permission findById(Long id){
        return permissionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evenement not found"));
    }

    /**
     * Enregistre une nouvelle permission.
     * @param permission la permission à enregistrer
     * @return la permission enregistré
     */
    public void save (Permission permission){
        permissionRepository.save(permission);
    }

    /**
     * Met à jour une permission.
     * @param permission la permission à mettre à jour
     * @param id l'identifiant de la permission
     * @return la permission mis à jour
     * @throws RuntimeException si la permission n'est pas trouvé
     */
    public Permission updateById(Long id, Permission permission) {
        Permission permissionActuelle = permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Demande de contact not found for id: " + id));
        permissionActuelle.setUtilisateurs(permission.getUtilisateurs());
        permissionActuelle.setStatut(permission.getStatut());
        return permissionRepository.save(permissionActuelle);
    }

    /**
     * Supprime une permission par son identifiant.
     * @param id l'identifiant de la permission à supprimer
     */
    public void deleteById(Long id){
        permissionRepository.deleteById(id);
    }

}
