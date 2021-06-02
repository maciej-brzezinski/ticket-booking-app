package ticket_booking_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket_booking_service.models.Reservation;
import ticket_booking_service.models.Screening;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}