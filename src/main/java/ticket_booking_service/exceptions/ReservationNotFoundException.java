package ticket_booking_service.exceptions;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(Long id) {
        super("Could not find reservation " + id);
    }
}