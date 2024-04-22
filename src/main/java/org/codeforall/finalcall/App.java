package org.codeforall.finalcall;

import org.codeforall.finalcall.exceptions.FlightNotFoundException;
import org.codeforall.finalcall.exceptions.PassengerNotFoundException;
import org.codeforall.finalcall.exceptions.SeatUnavailableException;
import org.codeforall.finalcall.exceptions.TicketNotFoundException;
import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.model.ticket.CabinClass;
import org.codeforall.finalcall.model.ticket.First;
import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;
import org.codeforall.finalcall.persistence.JpaBootstrap;
import org.codeforall.finalcall.persistence.dao.jpa.JpaAirportDao;
import org.codeforall.finalcall.persistence.dao.jpa.JpaFlightDao;
import org.codeforall.finalcall.persistence.dao.jpa.JpaPassengerDao;
import org.codeforall.finalcall.persistence.dao.jpa.JpaTicketDao;
import org.codeforall.finalcall.service.TicketServiceImpl;

import javax.persistence.EntityManagerFactory;

public class App {

    public static void main(String[] args) {

        JpaBootstrap jpa = new JpaBootstrap();
        EntityManagerFactory emf = jpa.start();

        // For testing purposes, we need to add spring
        JpaAirportDao airportDao = new JpaAirportDao();
        airportDao.setEm(emf.createEntityManager());

        JpaFlightDao flightDao = new JpaFlightDao();
        flightDao.setEm(emf.createEntityManager());

        JpaTicketDao ticketDao = new JpaTicketDao();
        ticketDao.setEm(emf.createEntityManager());

        JpaPassengerDao passengerDao = new JpaPassengerDao();
        passengerDao.setEm(emf.createEntityManager());

        jpa.stop();
    }
}
