package ticket_booking_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket_booking_service.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}