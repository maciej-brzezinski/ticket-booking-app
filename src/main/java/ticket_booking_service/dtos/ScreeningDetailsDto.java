package ticket_booking_service.dtos;

import ticket_booking_service.models.Seat;

import java.util.List;

public class ScreeningDetailsDto {

    private Long screeningId;
    private Long roomId;
    private List<Seat> seats;

    public ScreeningDetailsDto(Long screeningId, Long roomId, List<Seat> seats) {
        this.screeningId = screeningId;
        this.roomId = roomId;
        this.seats = seats;
    }

    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "ScreeningDetailsDto{" +
                "screeningId=" + screeningId +
                ", roomId=" + roomId +
                ", seats=" + seats +
                '}';
    }
}
