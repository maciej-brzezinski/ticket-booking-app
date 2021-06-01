package ticket_booking_service.tools;

import java.time.LocalDateTime;

public class HelperService {

    public static long RESERVATION_RETRIEVE_DEADLINE_BEFORE_SCREENING = 5L;
    public static int RESERVATION_CREATE_DEADLINE_BEFORE_SCREENING = 15;


    public static LocalDateTime getReservationRetrievalDeadlineFromScreeningTime(LocalDateTime screeningTime) {
        return screeningTime.minusMinutes(RESERVATION_RETRIEVE_DEADLINE_BEFORE_SCREENING);
    }

    public static LocalDateTime getReservationCreationDeadlineFromTime(LocalDateTime time) {
        return time.plusMinutes(RESERVATION_CREATE_DEADLINE_BEFORE_SCREENING);
    }

}
