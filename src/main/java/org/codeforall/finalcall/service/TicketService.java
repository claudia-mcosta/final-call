package org.codeforall.finalcall.service;

import org.codeforall.finalcall.exceptions.*;
import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;

public interface TicketService {

    Ticket get(TicketId ticketId);

    String checkIn(String nationalId, String flightCode, String seat) throws FlightNotFoundException, PassengerNotFoundException, SeatUnavailableException, TicketNotFoundException;

    void addCabinBag(String nationalId, TicketId ticketId, int quantity) throws ExcessBaggageException, PassengerNotFoundException, TicketNotFoundException;

    void addCheckedBag(String nationalId, TicketId ticketId, int quantity) throws ExcessBaggageException, PassengerNotFoundException, TicketNotFoundException;
}