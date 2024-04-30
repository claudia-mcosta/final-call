package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.*;
import io.codeforall.finalcall.persistence.dao.PassengerDao;
import io.codeforall.finalcall.persistence.dao.TicketDao;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.ticket.TicketId;
import io.codeforall.finalcall.persistence.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

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
    public Ticket get(TicketId ticketId) {
        return ticketDao.findById(ticketId);
    }

    @Transactional
    @Override
    public String checkIn(Integer pid, String flightCode, String seat) throws FlightNotFoundException, PassengerNotFoundException, SeatUnavailableException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(pid))
                .orElseThrow(PassengerNotFoundException::new);

        Flight flight = Optional.ofNullable(flightDao.findById(flightCode))
                .orElseThrow(FlightNotFoundException::new);

        Ticket ticket = Optional.ofNullable(ticketDao.findByFlightAndPassenger(flight, passenger))
                .orElseThrow(TicketNotFoundException::new);

        // Add method to DAO to get occupied seats list?
        List<String> occupiedSeats = ticketDao.findByFlight(flight).stream().map(Ticket::getSeat)
                                                                            .filter(s -> s != null)
                                                                            .collect(Collectors.toList());

        if (seat.isEmpty())
            seat = SeatRandomizer.getSeat(ticket.getCabinClass(), occupiedSeats);

        for (String s:occupiedSeats)
            if (seat.equals(s))
                throw new SeatUnavailableException();

        ticket.checkIn(seat);
        passengerDao.saveOrUpdate(passenger);

        return seat;
    }

    @Transactional
    @Override
    public void addCabinBag(Integer pid, String flightCode, int quantity) throws ExcessBaggageException, FlightNotFoundException, PassengerNotFoundException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(pid))
                .orElseThrow(PassengerNotFoundException::new);

        Flight flight = Optional.ofNullable(flightDao.findById(flightCode))
                .orElseThrow(FlightNotFoundException::new);

        Ticket ticket = Optional.ofNullable(ticketDao.findByFlightAndPassenger(flight, passenger))
                .orElseThrow(TicketNotFoundException::new);

        if (ticket.getCabinBags() + quantity >= 2) {
            throw new ExcessBaggageException();
        }

        ticket.addCabinBag(quantity);
        ticket.setPrice(ticket.getPrice() + 10);

        passengerDao.saveOrUpdate(passenger);
    }

    @Transactional
    @Override
    public void addCheckedBag(Integer pid, String flightCode, int quantity) throws ExcessBaggageException, FlightNotFoundException, PassengerNotFoundException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(pid))
                .orElseThrow(PassengerNotFoundException::new);

        Flight flight = Optional.ofNullable(flightDao.findById(flightCode))
                .orElseThrow(FlightNotFoundException::new);

        Ticket ticket = Optional.ofNullable(ticketDao.findByFlightAndPassenger(flight, passenger))
                .orElseThrow(TicketNotFoundException::new);

        if (ticket.getCheckedBags() + quantity >= 2) {
            throw new ExcessBaggageException();
        }

        ticket.addCheckedBag(quantity);
        ticket.setPrice(ticket.getPrice() + 20);

        passengerDao.saveOrUpdate(passenger);
    }
}