package ticket_booking_service.dtos;

import ticket_booking_service.models.Ticket;

import java.time.LocalDateTime;

public class ReservationResponseDto {

    private Ticket ticket;
    private String firstName;
    private String lastName;
    private LocalDateTime expirationDate;

    public ReservationResponseDto(Ticket ticket, String firstName, String lastName, LocalDateTime expirationDate) {
        this.ticket = ticket;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expirationDate = expirationDate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
