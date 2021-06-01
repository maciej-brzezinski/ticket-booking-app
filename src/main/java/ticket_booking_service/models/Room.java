package ticket_booking_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Room extends BaseModel {

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Screening> screenings;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Seat> seats;

    private int columnCount;

    private int rowCount;

    public Room(){}

    public Room(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

}
