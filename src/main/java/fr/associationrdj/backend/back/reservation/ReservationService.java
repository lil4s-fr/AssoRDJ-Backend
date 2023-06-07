package fr.associationrdj.backend.back.reservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.associationrdj.backend.back.reservation.dto.ReservationDTOFindAll;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ObjectMapper objectMapper;

    public ReservationService(ReservationRepository reservationRepository, ObjectMapper objectMapper) {
        this.reservationRepository = reservationRepository;
        this.objectMapper = objectMapper;
    }
    /**
     * Retourne toutes les reservations.
     * @return la liste des reservations filtrer selon ReservationDTOFindAll
     */
    public List<ReservationDTOFindAll> findAll(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservation -> objectMapper.convertValue(reservation, ReservationDTOFindAll.class) ).toList();
    }

    /**
     * Retourne une reservation par son identifiant.
     * @param id l'identifiant de la reservation
     * @return la reservation correspondant à l'identifiant
     * @throws ResponseStatusException si la reservation n'est pas trouvé
     */
    public Reservation findById(Long id){
        return reservationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
    }

    /**
     * Enregistre une nouvelle reservation.
     * @param reservation la reservation à enregistrer
     * @return la reservation enregistré
     */
    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    /**
     * Supprime une reservation par son identifiant.
     * @param id l'identifiant de la reservation à supprimer
     */
    public void deleteById(Long id){
        reservationRepository.deleteById(id);
    }

    /**
     * Met à jour une reservation.
     * @param reservation la reservation à mettre à jour
     * @param id l'identifiant de la reservation
     * @return la reservation mis à jour
     * @throws RuntimeException si la reservation n'est pas trouvé
     */
    public Reservation updateById(Long id, Reservation reservation){
        Reservation reservationActuel = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Demande de contact not found for id: " + id));
        reservationActuel.setDate_reservation(reservation.getDate_reservation());
        reservationActuel.setUtilisateurs(reservation.getUtilisateurs());
        reservationActuel.setDescription(reservation.getDescription());
        reservationActuel.setSalle(reservation.getSalle());
        reservationActuel.setValidation(reservation.isValidation());
        reservationActuel.setDate_evenement(reservation.getDate_evenement());
        return reservationRepository.save(reservationActuel);
    }
}
