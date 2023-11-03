package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.model.ticket.Ticket;

import java.util.List;

public interface PassengerService {

    Passenger get(String nationalId);

    Passenger save(Passenger passenger);

    void delete(String nationalId);

    List<Passenger> list();

    List<Ticket> listTickets(String nationalId);

    Ticket buyTicket(String nationalId);

    void cancelTicket();
}
