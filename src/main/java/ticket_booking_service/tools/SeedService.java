package ticket_booking_service.tools;

import ticket_booking_service.models.Movie;
import ticket_booking_service.models.Room;
import ticket_booking_service.models.Screening;
import ticket_booking_service.models.Seat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SeedService {

    public static int DEFAULT_MOVIE_DURATION = 100;
    public static int MOVIE_DURATION_OFFSET_LIMIT = 30;
    public static int BREAK_BETWEEN_SCREENINGS = 10;

    public static List<Seat> generateSeats(Room room) {

        List<Seat> seats = new ArrayList<>();
        for (int col = 1; col <= room.getColumnCount(); col++) {
            for (int row = 1; row <= room.getRowCount(); row++) {
                seats.add(new Seat(room, col, row));
            }
        }
        return seats;
    }

    public static List<Room> generateRooms(int howMany, int columnCount, int rowCount) {

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            rooms.add(new Room(columnCount, rowCount));
        }
        return rooms;
    }

    public static List<Movie> generateMovies(int howMany) {

        List<Movie> movies = new ArrayList<>();
        for (int count = 1; count <= howMany; count++) {
            movies.add(new Movie("movie "+ count, randomizeDuration(DEFAULT_MOVIE_DURATION, MOVIE_DURATION_OFFSET_LIMIT)));
        }
        return movies;
    }

    private static int randomizeDuration(int duration, int offsetLimit) {
        Random random = new Random();
        int offset = offsetLimit - 2 * random.nextInt(offsetLimit);
        return duration + offset;
    }

    public static List<Screening> generateScreenings(List<Movie> movies, List<Room> rooms) {
        List<Screening> screenings = new ArrayList<>();

        rooms.forEach(room->{

            var timeBetweenScreenings = new AtomicInteger(BREAK_BETWEEN_SCREENINGS);
            movies.forEach(movie -> {
                LocalDateTime date = LocalDateTime.now().plusMinutes(timeBetweenScreenings.get());
                screenings.add(new Screening(movie, room, date));
                timeBetweenScreenings.addAndGet(movie.getDurationInMinutes() + BREAK_BETWEEN_SCREENINGS);
            });
        });

        return screenings;
    }


}
