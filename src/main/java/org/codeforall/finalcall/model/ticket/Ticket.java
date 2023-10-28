package org.codeforall.finalcall.model.ticket;

import org.codeforall.finalcall.SeatRandomizer;
import org.codeforall.finalcall.model.*;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cabin_class")
public abstract class Ticket {

    @Id
    @ManyToOne
    protected Flight flight;
    @Id
    @ManyToOne
    protected Passenger passenger;
    protected String seat;
    // Each subclass is created with a num of cabinbags + checkinbags included that can be incremented? Seats are affected also?
    // Check if decorator pattern applies here
    protected int cabinBags;
    protected int checkInBags;
    protected boolean checkIn;

    public abstract CabinClass getCabinClass();

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
        checkInBags += quantity;
    }

}
