package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;
import org.codeforall.finalcall.exceptions.*;
import org.codeforall.finalcall.persistence.dao.PassengerDao;
import org.codeforall.finalcall.persistence.dao.TicketDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassengerServiceImpl implements PassengerService{

    private PassengerDao passengerDao;
    private TicketDao ticketDao;

    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Passenger get(String nationalId) {
        return passengerDao.findById(nationalId);
    }

    @Override
    public Passenger save(Passenger passenger) {
        return passengerDao.saveOrUpdate(passenger);
    }

    @Override
    public void delete(String nationalId) throws PassengerNotFoundException, AssociationExistsException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(nationalId))
                .orElseThrow(PassengerNotFoundException::new);

        if (!passenger.getTickets().isEmpty()) {
            throw new AssociationExistsException();
        }

        passengerDao.delete(nationalId);
    }

    @Override
    public List<Passenger> list() {
        return passengerDao.findAll();
    }

    @Override
    public List<Ticket> listTickets(String nationalId) throws PassengerNotFoundException {
        Passenger passenger = Optional.ofNullable(passengerDao.findById(nationalId))
                .orElseThrow(PassengerNotFoundException::new);

        return new ArrayList<>(passenger.getTickets());
    }

    @Override
    public Ticket buyTicket(String nationalId, Ticket ticket) throws PassengerNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(nationalId))
                .orElseThrow(PassengerNotFoundException::new);

        passenger.buyTicket(ticket);
        passengerDao.saveOrUpdate(passenger);

        return passenger.getTickets().get(passenger.getTickets().size() - 1);
    }

    @Override
    public void cancelTicket(String nationalId, TicketId ticketId) throws PassengerNotFoundException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(nationalId))
                .orElseThrow(PassengerNotFoundException::new);

        Ticket ticket = Optional.ofNullable(ticketDao.findById(ticketId))
                .orElseThrow(TicketNotFoundException::new);

        if (!ticket.getPassenger().getNationalId().equals(nationalId)) {
            throw new TicketNotFoundException();
        }

        passenger.cancelTicket(ticket);
        ticketDao.delete(ticketId);
        passengerDao.saveOrUpdate(passenger);
    }
}
