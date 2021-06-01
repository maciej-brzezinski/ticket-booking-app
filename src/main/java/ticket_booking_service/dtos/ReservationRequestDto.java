package ticket_booking_service.dtos;

import ticket_booking_service.tools.HelperService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class ReservationRequestDto {

    private Long screeningId;
    private Long ticketId;

    private String firstName;

    private String lastName;
    private List<Long> seatIds;

    public ReservationRequestDto(Long screeningId, Long ticketId, String firstName, String lastName, List<Long> seatIds) {
        this.screeningId = screeningId;
        this.ticketId = ticketId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.seatIds = seatIds;
    }

    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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

    public List<Long> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Long> seatIds) {
        this.seatIds = seatIds;
    }
}

