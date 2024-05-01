package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.FlightNotFoundException;
import io.codeforall.finalcall.exceptions.PassengerNotFoundException;
import io.codeforall.finalcall.exceptions.TicketNotFoundException;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger get(Integer id);

    Passenger save(Passenger passenger);

    void delete(Integer id) throws PassengerNotFoundException;
}