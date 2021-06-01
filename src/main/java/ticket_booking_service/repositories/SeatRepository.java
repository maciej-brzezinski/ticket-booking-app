package ticket_booking_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket_booking_service.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}