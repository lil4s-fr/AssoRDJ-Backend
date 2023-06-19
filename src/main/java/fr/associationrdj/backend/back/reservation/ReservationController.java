package fr.associationrdj.backend.back.reservation;

import fr.associationrdj.backend.back.reservation.dto.ReservationDTOFindAll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping("")
    public List<ReservationDTOFindAll> findAll(){
        return reservationService.findAll();
    }
    @GetMapping("/{id}")
    public Reservation findById(@PathVariable("id") Long id){
        return reservationService.findById(id);
    }
    @PostMapping("")
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        reservationService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Reservation updateById(@PathVariable("id")Long id, @RequestBody Reservation reservation){
        return reservationService.updateById(id, reservation);
    }
}
