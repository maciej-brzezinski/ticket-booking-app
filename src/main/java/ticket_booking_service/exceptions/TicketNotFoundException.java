package ticket_booking_service.exceptions;

public class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException(Long id) {
        super("Could not find ticket " + id);
    }
}