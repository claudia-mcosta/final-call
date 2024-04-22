package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.FlightNotFoundException;
import io.codeforall.finalcall.exceptions.PassengerNotFoundException;
import io.codeforall.finalcall.exceptions.TicketNotFoundException;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger get(String nationalId);

    Passenger save(Passenger passenger);

    void delete(String nationalId) throws PassengerNotFoundException;

    List<Passenger> list();

    List<Ticket> listTickets(Passenger passenger) throws PassengerNotFoundException;

    Ticket buyTicket(String nationalId, Ticket ticket) throws PassengerNotFoundException;

    void cancelTicket(String nationalId, String flightCode) throws FlightNotFoundException, PassengerNotFoundException, TicketNotFoundException;
}