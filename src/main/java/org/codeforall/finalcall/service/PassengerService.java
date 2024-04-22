package org.codeforall.finalcall.service;

import org.codeforall.finalcall.exceptions.*;
import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;

import java.util.List;

public interface PassengerService {

    Passenger get(String nationalId);

    Passenger save(Passenger passenger);

    void delete(String nationalId)  throws PassengerNotFoundException, AssociationExistsException;

    List<Passenger> list();

    List<Ticket> listTickets(String nationalId) throws PassengerNotFoundException;

    Ticket buyTicket(String nationalId, Ticket ticket) throws PassengerNotFoundException;

    void cancelTicket(String nationalId, TicketId ticketId) throws PassengerNotFoundException, TicketNotFoundException ;
}
