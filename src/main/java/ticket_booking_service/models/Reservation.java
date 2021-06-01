package ticket_booking_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservation extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "screeningId")
    @JsonIgnore
    private Screening screening;

    @OneToMany(mappedBy = "reservation")
    private List<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "ticketId")
    private Ticket ticket;

    private String firstName;

    private String lastName;

    private LocalDateTime expirationDate;

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Reservation(){}

    public Reservation(Screening screening, Ticket ticket, String firstName, String lastName, List<Seat> seats, LocalDateTime expirationDate) {
        this.screening = screening;
        this.ticket = ticket;
        this.firstName = firstName;
        this.lastName = lastName;
        this.seats = seats;
        this.expirationDate = expirationDate;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
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


}
