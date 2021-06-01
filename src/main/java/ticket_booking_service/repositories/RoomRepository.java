package ticket_booking_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket_booking_service.models.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
}