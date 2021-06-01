package ticket_booking_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ticket_booking_service.models.Movie;
import ticket_booking_service.models.Room;
import ticket_booking_service.models.Screening;
import ticket_booking_service.models.Ticket;
import ticket_booking_service.repositories.*;
import ticket_booking_service.tools.SeedService;

import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            MovieRepository movieRepository,
            ReservationRepository reservationRepository,
            RoomRepository roomRepository,
            ScreeningRepository screeningRepository,
            SeatRepository seatRepository,
            TicketRepository ticketRepository
            ) {

        return args -> {

            List<Movie> movies = SeedService.generateMovies(3);
            movieRepository.saveAll(movies);
            movieRepository.findAll().forEach(movie -> log.info("Preloaded " + movie));

            List<Room> rooms = SeedService.generateRooms(4, 6, 6);
            roomRepository.saveAll(rooms);
            roomRepository.findAll().forEach(room -> log.info("Preloaded " + room));

            rooms.forEach(room -> seatRepository.saveAll(SeedService.generateSeats(room)));
            seatRepository.findAll().forEach(seat -> log.info("Preloaded " + seat));

            List<Screening> screenings = SeedService.generateScreenings(movies, rooms);
            screeningRepository.saveAll(screenings);
            screeningRepository.findAll().forEach(screening -> log.info("Preloaded " + screening));

            ticketRepository.save(new Ticket("ADULT", 25));
            ticketRepository.save(new Ticket("STUDENT", 18));
            ticketRepository.save(new Ticket("CHILD", 12.5));

            ticketRepository.findAll().forEach(ticket -> log.info("Preloaded " + ticket));

        };
    }
}