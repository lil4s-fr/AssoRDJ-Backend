package fr.associationrdj.backend.back.reservation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }
    public Reservation findById(Long id){
        return reservationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
    }
    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public void deleteById(Long id){
        reservationRepository.deleteById(id);
    }
    public Reservation update(Reservation reservation){
        Reservation reservationActuel = reservationRepository.findById(reservation.getId()).orElse(null);
        if (reservationActuel != null){
            reservationActuel.setDate_reservation(reservation.getDate_reservation());
            reservationActuel.setCreneau(reservation.getCreneau());
            reservationActuel.setUtilisateurs(reservation.getUtilisateurs());
            reservationActuel.setDescription(reservation.getDescription());
            reservationActuel.setSalle(reservation.getSalle());
            reservationActuel.setValidation(reservation.isValidation());
            reservationActuel.setDate_evenement(reservation.getDate_evenement());
            return reservationRepository.save(reservation);
        }else {
            throw new RuntimeException("Reservation not found for id : ");
        }
    }
}
