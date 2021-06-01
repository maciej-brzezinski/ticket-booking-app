package ticket_booking_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket_booking_service.models.Room;
import ticket_booking_service.models.Screening;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Screening> findByStartTimeBetween(LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo);
}