package org.codeforall.finalcall.service;

import org.codeforall.finalcall.exceptions.*;
import org.codeforall.finalcall.persistence.model.Passenger;
import org.codeforall.finalcall.persistence.model.ticket.Ticket;
import org.codeforall.finalcall.persistence.model.ticket.TicketId;

import java.util.List;

public interface PassengerService {

    Passenger get(String nationalId);

    Passenger save(Passenger passenger);

    void delete(String nationalId)  throws PassengerNotFoundException, AssociationExistsException;

    List<Passenger> list();

    List<Ticket> listTickets(Passenger passenger) throws PassengerNotFoundException;

    Ticket buyTicket(String nationalId, Ticket ticket) throws PassengerNotFoundException;

    void cancelTicket(String nationalId, String flightCode) throws FlightNotFoundException, PassengerNotFoundException, TicketNotFoundException ;
}