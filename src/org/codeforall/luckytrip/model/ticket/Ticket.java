package org.codeforall.luckytrip.model.ticket;

import org.codeforall.luckytrip.SeatRandomizer;
import org.codeforall.luckytrip.model.Flight;
import org.codeforall.luckytrip.model.Passenger;

public abstract class Ticket {

    protected Flight flight;
    protected Passenger passenger;
    protected String seat;
    // Each subclass is created with a num of cabinbags + checkinbags included that can be incremented? Seats are affected also?
    protected int cabinBags;
    protected int checkInBags;
    protected boolean checkIn;

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
