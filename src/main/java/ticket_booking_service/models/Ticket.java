package ticket_booking_service.models;

import javax.persistence.Entity;

@Entity
public class Ticket extends BaseModel {

    private String type;

    private double price;

    public Ticket() {
    }

    public Ticket(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}


