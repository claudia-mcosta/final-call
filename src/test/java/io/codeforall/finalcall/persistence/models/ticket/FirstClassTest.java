package io.codeforall.finalcall.persistence.models.ticket;

import io.codeforall.finalcall.persistence.model.ticket.CabinClass;
import io.codeforall.finalcall.persistence.model.ticket.FirstClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstClassTest {

    private FirstClass ticket;

    @Before
    public void setup() {
        ticket = new FirstClass();
    }

    @Test
    public void testCabinClass() {
        Assert.assertEquals(CabinClass.FIRST, ticket.getCabinClass());
    }

    @Test
    public void testInitialCabinBags() {
        assertEquals(2, ticket.getCabinBags());
    }

    @Test
    public void testInitialCheckedBags() {
        assertEquals(2, ticket.getCheckedBags());
    }

    @Test
    public void testAddCabinBagsFail() {
        ticket.addCabinBag(1);
        assertEquals(FirstClass.FREE_CABIN_BAGS, ticket.getCabinBags());
    }

    @Test
    public void testAddCheckedBagsFail() {
        ticket.addCheckedBag(1);
        assertEquals(FirstClass.FREE_CHECKED_BAGS, ticket.getCheckedBags());
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
