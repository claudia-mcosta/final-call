package org.codeforall.finalcall.persistence.dao;

import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;

import java.util.List;

public interface TicketDao extends Dao<Ticket, TicketId> {

    List<Ticket> findByFlight(Flight flight);

    List<Ticket> findByPassenger(Passenger passenger);
}
