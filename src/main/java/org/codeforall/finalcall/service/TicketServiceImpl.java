package org.codeforall.finalcall.service;

import org.codeforall.finalcall.SeatRandomizer;
import org.codeforall.finalcall.exceptions.*;
import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;
import org.codeforall.finalcall.persistence.dao.FlightDao;
import org.codeforall.finalcall.persistence.dao.PassengerDao;
import org.codeforall.finalcall.persistence.dao.TicketDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    private FlightDao flightDao;
    private PassengerDao passengerDao;
    private TicketDao ticketDao;

    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }
    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket get(TicketId ticketId) {
        return ticketDao.findById(ticketId);
    }

    @Override
    public String checkIn(String nationalId, String flightCode, String seat) throws FlightNotFoundException, PassengerNotFoundException, SeatUnavailableException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(nationalId))
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

    @Override
    public void addCabinBag(String nationalId, TicketId ticketId, int quantity) throws ExcessBaggageException, PassengerNotFoundException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(nationalId))
                .orElseThrow(PassengerNotFoundException::new);

        Ticket ticket = Optional.ofNullable(ticketDao.findById(ticketId))
                .orElseThrow(TicketNotFoundException::new);

        if (ticket.getCabinBags() + quantity >= 2) {
            throw new ExcessBaggageException();
        }

        ticket.addCabinBag(quantity);
        ticket.setPrice(ticket.getPrice() + 10);

        passengerDao.saveOrUpdate(passenger);
    }

    @Override
    public void addCheckedBag(String nationalId, TicketId ticketId, int quantity) throws ExcessBaggageException, PassengerNotFoundException, TicketNotFoundException {

        Passenger passenger = Optional.ofNullable(passengerDao.findById(nationalId))
                .orElseThrow(PassengerNotFoundException::new);

        Ticket ticket = Optional.ofNullable(ticketDao.findById(ticketId))
                .orElseThrow(TicketNotFoundException::new);

        if (ticket.getCabinBags() + quantity >= 2) {
            throw new ExcessBaggageException();
        }

        ticket.addCheckedBag(quantity);
        ticket.setPrice(ticket.getPrice() + 20);

        passengerDao.saveOrUpdate(passenger);
    }
}