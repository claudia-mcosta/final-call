package io.codeforall.finalcall.persistence.models.ticket;

import io.codeforall.finalcall.persistence.model.ticket.CabinClass;
import io.codeforall.finalcall.persistence.model.ticket.PremiumEconomyClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PremiumEconomyClassTest {

    private PremiumEconomyClass ticket;

    @Before
    public void setup() {
        ticket = new PremiumEconomyClass();
    }

    @Test
    public void testCabinClass() {
        assertEquals(CabinClass.PREMIUM_ECONOMY, ticket.getCabinClass());
    }

    @Test
    public void testInitialCabinBags() {
        assertEquals(1, ticket.getCabinBags());
    }

    @Test
    public void testInitialCheckedBags() {
        assertEquals(0, ticket.getCheckedBags());
    }

    @Test
    public void testAddCabinBagsSuccess() {
        ticket.addCabinBag(1);
        assertEquals(PremiumEconomyClass.FREE_CABIN_BAGS + 1, ticket.getCabinBags());
    }

    @Test
    public void testAddCabinBagsFail() {
        ticket.addCabinBag(2);
        assertEquals(PremiumEconomyClass.FREE_CABIN_BAGS, ticket.getCabinBags());
    }

    @Test
    public void testAddCheckedBagsSuccess() {
        ticket.addCheckedBag(2);
        assertEquals(PremiumEconomyClass.FREE_CHECKED_BAGS + 2, ticket.getCheckedBags());
    }

    @Test
    public void testAddCheckedBagsFail() {
        ticket.addCheckedBag(3);
        assertEquals(PremiumEconomyClass.FREE_CHECKED_BAGS, ticket.getCheckedBags());
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
