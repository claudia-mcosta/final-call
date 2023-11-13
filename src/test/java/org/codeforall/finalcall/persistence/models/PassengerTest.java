package org.codeforall.finalcall.persistence.models;

import org.codeforall.finalcall.persistence.model.Passenger;
import org.codeforall.finalcall.persistence.model.ticket.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class PassengerTest {

    private Passenger passenger;
    private Ticket ticket;

    @Before
    public void setup() {
        passenger = new Passenger();
        ticket = Mockito.mock(Ticket.class);
    }

    @Test
    public void testAddTicket() {

        passenger.addTicket(ticket);

        verify(ticket).setPassenger(passenger);
        assertEquals(1, passenger.getTickets().size());
        assertEquals(ticket, passenger.getTickets().get(0));
    }

    @Test
    public void testRemoveTicket() {

        passenger.removeTicket(ticket);

        verify(ticket).setPassenger(null);
        assertEquals(0, passenger.getTickets().size());
    }
}
