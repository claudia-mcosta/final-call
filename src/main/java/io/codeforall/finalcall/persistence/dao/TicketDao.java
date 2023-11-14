package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.ticket.TicketId;

import java.util.List;

public interface TicketDao extends Dao<Ticket, TicketId> {

    Ticket findByFlightAndPassenger(Flight flight, Passenger passenger);
    List<Ticket> findByFlight(Flight flight);

    List<Ticket> findByPassenger(Passenger passenger);
}
