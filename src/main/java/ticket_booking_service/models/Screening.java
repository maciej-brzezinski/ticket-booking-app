package ticket_booking_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Screening extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "movieId")
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "roomId")
    @JsonIgnore
    private Room room;

    @OneToMany(mappedBy = "screening")
    @JsonIgnore
    private List<Reservation> reservations;

    private LocalDateTime startTime;

    public Screening() {
    }

    public Screening(Movie movie, Room room, LocalDateTime startTime) {
        this.movie = movie;
        this.room = room;
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "movie=" + movie +
                ", room=" + room +
                ", startTime=" + startTime +
                '}';
    }
}
