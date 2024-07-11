package io.codeforall.finalcall.persistence.models.ticket;

import io.codeforall.finalcall.persistence.model.ticket.CabinClass;
import io.codeforall.finalcall.persistence.model.ticket.EconomyClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EconomyClassTest {

    private EconomyClass ticket;

    @Before
    public void setup() {
        ticket = new EconomyClass();
    }

    @Test
    public void testCabinClass() {
        assertEquals(CabinClass.ECONOMY, ticket.getCabinClass());
    }

    @Test
    public void testInitialCabinBags() {
        assertEquals(0, ticket.getCabinBags());
    }

    @Test
    public void testInitialCheckedBags() {
        assertEquals(0, ticket.getCheckedBags());
    }

    @Test
    public void testAddCabinBagsSuccess() {
        ticket.addCabinBag(2);
        assertEquals(EconomyClass.FREE_CABIN_BAGS + 2, ticket.getCabinBags());
    }

    @Test
    public void testAddCabinBagsFail() {
        ticket.addCabinBag(3);
        assertEquals(EconomyClass.FREE_CABIN_BAGS, ticket.getCabinBags());
    }

    @Test
    public void testAddCheckedBagsSuccess() {
        ticket.addCheckedBag(2);
        assertEquals(EconomyClass.FREE_CHECKED_BAGS + 2, ticket.getCheckedBags());
    }

    @Test
    public void testAddCheckedBagsFail() {
        ticket.addCheckedBag(3);
        assertEquals(EconomyClass.FREE_CHECKED_BAGS, ticket.getCheckedBags());
    }

    @Test
    public void testCheckInSuccess() {
        ticket.checkIn("1A");
        assertEquals("1A", ticket.getSeat());
    }

    @Test
    public void testCheckInFail() {
        ticket.checkIn("1A");
        ticket.checkIn("2B");
        assertEquals("1A", ticket.getSeat());
    }
}
