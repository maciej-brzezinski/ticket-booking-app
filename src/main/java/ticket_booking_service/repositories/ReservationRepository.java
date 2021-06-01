package ticket_booking_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket_booking_service.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}