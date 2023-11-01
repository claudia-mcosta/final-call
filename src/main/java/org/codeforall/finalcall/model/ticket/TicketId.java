package org.codeforall.finalcall.model.ticket;

import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.model.Passenger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class TicketId implements Serializable {

    @ManyToOne
    protected Flight flight;
    @ManyToOne
    protected Passenger passenger;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketId)) return false;
        TicketId ticketId = (TicketId) o;
        return Objects.equals(getFlight(), ticketId.getFlight()) && Objects.equals(getPassenger(), ticketId.getPassenger());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getPassenger());
    }

    @Override
    public String toString() {
        return "TicketId{" +
                "flight=" + flight.getCode() +
                ", passenger=" + passenger.getNationalId() +
                '}';
    }
}
