package ticket_booking_service.exceptions;

public class SeatNotFoundException extends RuntimeException {

    public SeatNotFoundException(Long id) {
        super("Could not find seat " + id);
    }
}