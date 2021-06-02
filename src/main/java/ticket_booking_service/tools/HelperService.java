package ticket_booking_service.tools;

import ticket_booking_service.models.Movie;
import ticket_booking_service.models.Room;
import ticket_booking_service.models.Screening;
import ticket_booking_service.models.Seat;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class HelperService {

    public static long RESERVATION_RETRIEVE_DEADLINE_BEFORE_SCREENING = 5L;
    public static int RESERVATION_CREATE_DEADLINE_BEFORE_SCREENING = 15;
    public final static String LAST_NAME_REGEX = "\\p{Lu}(\\p{Ll}*)(\\-\\p{Lu}(\\p{Ll}*))?";
    public final static String FIRST_NAME_REGEX = "\\p{Lu}(\\p{Ll}*)";

    public static LocalDateTime getReservationRetrievalDeadlineFromScreeningTime(LocalDateTime screeningTime) {
        return screeningTime.minusMinutes(RESERVATION_RETRIEVE_DEADLINE_BEFORE_SCREENING);
    }

    public static LocalDateTime getReservationCreationDeadlineFromTime(LocalDateTime time) {
        return time.plusMinutes(RESERVATION_CREATE_DEADLINE_BEFORE_SCREENING);
    }

}
