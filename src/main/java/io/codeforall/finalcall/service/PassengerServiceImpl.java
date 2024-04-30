package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.FlightNotFoundException;
import io.codeforall.finalcall.exceptions.PassengerNotFoundException;
import io.codeforall.finalcall.exceptions.TicketNotFoundException;
import io.codeforall.finalcall.persistence.dao.PassengerDao;
import io.codeforall.finalcall.persistence.dao.TicketDao;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private FlightDao flightDao;
    private PassengerDao passengerDao;
    private TicketDao ticketDao;

    @Autowired
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Autowired
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Autowired
    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Passenger get(Integer id) {
        return passengerDao.findById(id);
    }

    @Transactional
    @Override
    public Passenger save(Passenger passenger) {
        return passengerDao.saveOrUpdate(passenger);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws PassengerNotFoundException {

        Optional.ofNullable(passengerDao.findById(id))
                .orElseThrow(PassengerNotFoundException::new);

        passengerDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Passenger> list() {
        return passengerDao.findAll();
    }

    @Override
    public List<Ticket> listTickets(Passenger passenger) {
        return passenger.getTickets();
    }

    @Transactional
    @Override
    public Ticket buyTicket(Integer id, Ticket ticket) throws PassengerNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(id))
                .orElseThrow(PassengerNotFoundException::new);

        passenger.addTicket(ticket);
        passengerDao.saveOrUpdate(passenger);

        return passenger.getTickets().get(passenger.getTickets().size() - 1);
    }

    @Transactional
    @Override
    public void cancelTicket(Integer id, String flightCode) throws FlightNotFoundException, PassengerNotFoundException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(id))
                .orElseThrow(PassengerNotFoundException::new);

        Flight flight = Optional.ofNullable(flightDao.findById(flightCode))
                .orElseThrow(FlightNotFoundException::new);

        Ticket ticket = Optional.ofNullable(ticketDao.findByFlightAndPassenger(flight, passenger))
                .orElseThrow(TicketNotFoundException::new);

        if (!ticket.getPassenger().getId().equals(id)) {
            throw new TicketNotFoundException();
        }

        passenger.removeTicket(ticket);
        passengerDao.saveOrUpdate(passenger);
    }
}
