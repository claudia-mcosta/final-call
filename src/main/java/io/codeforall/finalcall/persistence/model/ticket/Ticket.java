package io.codeforall.finalcall.persistence.model.ticket;

import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.Passenger;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cabin_class")
@IdClass(TicketId.class)
public abstract class Ticket {

    // TODO: Couldn't make Embbedable work with the mappedBy in Passenger class. Check what is best in this situation --> https://jpa-buddy.com/blog/the-ultimate-guide-on-composite-ids-in-jpa-entities/
    @Id
    @ManyToOne
    protected Flight flight;
    @Id
    @ManyToOne
    protected Passenger passenger;
    protected double price;
    protected String seat;

    // TODO: Check if decorator pattern applies here if each subclass is created with a num of cabinbags + checkinbags included that can be incremented. Seats are affected also?
    @Column(name = "cabin_bags")
    protected int cabinBags;
    @Column(name = "checked_bags")
    protected int checkedBags;
    // protected boolean checkIn;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void checkIn(String seat){
        if (this.seat == null)
            this.seat = seat;
    }

    public int getCabinBags() {
        return cabinBags;
    }

    public void addCabinBag(int quantity){
        if (cabinBags + quantity <= 2)
            cabinBags += quantity;
    }

    public int getCheckedBags() {
        return checkedBags;
    }

    public void addCheckedBag(int quantity){
        if (checkedBags + quantity <= 2)
            checkedBags += quantity;
    }

    public abstract CabinClass getCabinClass();

    @Override
    public String toString() {
        return "Ticket{" +
                "flight=" + flight.getCode() +
                ", passenger=" + passenger.getNationalId() +
                ", cabinClass=" + getCabinClass() +
                ", price=" + price +
                ", seat=" + seat +
                ", cabinBags=" + cabinBags +
                ", checkedBags=" + checkedBags +
                '}';
    }
}
