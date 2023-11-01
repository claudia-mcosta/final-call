package org.codeforall.finalcall.model.ticket;

import org.codeforall.finalcall.model.*;

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

    public abstract CabinClass getCabinClass();

    @Override
    public String toString() {
        return "Ticket{" +
                "flight=" + flight.getCode() +
                ", passenger=" + passenger.getNationalId() +
                ", price=" + price +
                ", seat='" + seat + '\'' +
                ", cabinBags=" + cabinBags +
                ", checkedBags=" + checkedBags +
                '}';
    }

    /*
    // Place these methods in services?

    public void checkIn(){
        this.checkIn = true;
        this.seat = SeatRandomizer.getSeat();
    }

    public void checkIn(String seat){
        this.checkIn = true;
        this.seat = seat;
    }

    public void addCabinBag(int quantity){
        cabinBags += quantity;
    }

    public void addCheckInBag(int quantity){
        checkedBags += quantity;
    }
*/
}
