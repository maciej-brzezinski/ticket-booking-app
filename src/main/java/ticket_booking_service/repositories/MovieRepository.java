package ticket_booking_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket_booking_service.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}