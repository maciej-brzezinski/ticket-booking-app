package ticket_booking_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Seat extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "roomId")
    @JsonIgnore
    private Room room;

    @ManyToOne
    @JoinColumn(name = "reservationId")
    @JsonIgnore
    private Reservation reservation;

    private int columnNo;

    private int rowNo;

    public Seat(){}

    public Seat(Room room, int columnNo, int rowNo) {
        this.room = room;
        this.columnNo = columnNo;
        this.rowNo = rowNo;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getColumn() {
        return columnNo;
    }

    public void setColumn(int columnNo) {
        this.columnNo = columnNo;
    }

    public int getRow() {
        return rowNo;
    }

    public void setRow(int rowNo) {
        this.rowNo = rowNo;
    }

    @Override
    public String toString() {
        return "Seat{" +
                ", reservation=" + reservation +
                ", columnNo=" + columnNo +
                ", rowNo=" + rowNo +
                '}';
    }
}
