package org.codeforall.finalcall.model.ticket;

import org.codeforall.finalcall.SeatRandomizer;
import org.codeforall.finalcall.model.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tickets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cabin_class")
public abstract class Ticket implements Serializable {

    @Id
    @ManyToOne
    protected Flight flight;
    @Id
    @ManyToOne
    protected Passenger passenger;
    protected double price;
    protected String seat;
    // Each subclass is created with a num of cabinbags + checkinbags included that can be incremented? Seats are affected also?
    // Check if decorator pattern applies here
    @Column(name = "cabin_bags")
    protected int cabinBags;
    @Column(name = "checked_bags")
    protected int checkedBags;
    // protected boolean checkIn;

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public abstract CabinClass getCabinClass();

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
