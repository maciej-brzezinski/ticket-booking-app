package ticket_booking_service.exceptions;

public class ScreeningNotFoundException extends RuntimeException {

    public ScreeningNotFoundException(Long id) {
        super("Could not find screening " + id);
    }
}