package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.*;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.ticket.TicketId;

public interface TicketService {

    Ticket get(TicketId ticketId);

    String checkIn(String nationalId, String flightCode, String seat) throws FlightNotFoundException, PassengerNotFoundException, SeatUnavailableException, TicketNotFoundException;

    void addCabinBag(String nationalId, String flightCode, int quantity) throws ExcessBaggageException, FlightNotFoundException, PassengerNotFoundException, TicketNotFoundException;

    void addCheckedBag(String nationalId, String flightCode, int quantity) throws ExcessBaggageException, FlightNotFoundException, PassengerNotFoundException, TicketNotFoundException;
}