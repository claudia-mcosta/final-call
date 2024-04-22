package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.dao.jpa.JpaTicketDao;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.ticket.TicketId;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JpaTicketDaoTest {

    private JpaTicketDao ticketDao;
    private EntityManager em;

    @Before
    public void setup() {

        em = mock(EntityManager.class);

        ticketDao = new JpaTicketDao();
        ticketDao.setEm(em);
    }

    @Test
    public void testFindAll() {

        List<Ticket> mockTickets = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Ticket.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockTickets);

        List<Ticket> tickets = ticketDao.findAll();

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockTickets, tickets);
    }

    @Test
    public void testFindById() {

        Ticket mockTicket = mock(Ticket.class);
        TicketId mockTicketId = mock(TicketId.class);

        when(em.find(Ticket.class, mockTicketId)).thenReturn(mockTicket);

        Ticket ticket = ticketDao.findById(mockTicketId);

        verify(em, times(1)).find(Ticket.class, mockTicketId);
        assertEquals(mockTicket, ticket);
    }

    @Test
    public void testSaveOrUpdate() {

        Ticket mockTicket = mock(Ticket.class);

        when(em.merge(mockTicket)).thenReturn(mockTicket);

        Ticket ticket = ticketDao.saveOrUpdate(mockTicket);

        verify(em, times(1)).merge(mockTicket);
        assertEquals(mockTicket, ticket);
    }

    @Test
    public void testDelete() {

        Ticket mockTicket = mock(Ticket.class);
        TicketId mockTicketId = mock(TicketId.class);

        when(em.find(Ticket.class, mockTicketId)).thenReturn(mockTicket);

        ticketDao.delete(mockTicketId);

        verify(em, times(1)).find(Ticket.class, mockTicketId);
        verify(em, times(1)).remove(mockTicket);
    }

    @Test
    public void testFindByFlightAndPassenger() {

        Ticket mockTicket = mock(Ticket.class);
        Flight mockFlight = mock(Flight.class);
        Passenger mockPassenger = mock(Passenger.class);
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        Root root = mock(Root.class);
        Path path = mock(Path.class);
        Predicate predicate = mock(Predicate.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Ticket.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Ticket.class)).thenReturn(root);
        when(root.get(anyString())).thenReturn(path);
        when(criteriaBuilder.equal(any(Path.class), any(Class.class))).thenReturn(predicate);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getSingleResult()).thenReturn(mockTicket);

        Ticket ticket = ticketDao.findByFlightAndPassenger(mockFlight, mockPassenger);

        verify(typedQuery, times(1)).getSingleResult();
        assertEquals(mockTicket, ticket);
    }

    @Test
    public void testFindByFlight() {

        List<Ticket> mockTickets = new ArrayList<>();
        Flight mockFlight = mock(Flight.class);

        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        Root root = mock(Root.class);
        Path path = mock(Path.class);
        Predicate predicate = mock(Predicate.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Ticket.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Ticket.class)).thenReturn(root);
        when(root.get(anyString())).thenReturn(path);
        when(criteriaBuilder.equal(any(Path.class), any(Class.class))).thenReturn(predicate);
        when(criteriaQuery.where(any(Predicate.class))).thenReturn(criteriaQuery);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockTickets);

        List<Ticket> tickets = ticketDao.findByFlight(mockFlight);

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockTickets, tickets);
    }

    @Test
    public void testFindByPassenger() {

        List<Ticket> mockTickets = new ArrayList<>();
        Passenger mockPassenger = mock(Passenger.class);

        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        Root root = mock(Root.class);
        Path path = mock(Path.class);
        Predicate predicate = mock(Predicate.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Ticket.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Ticket.class)).thenReturn(root);
        when(root.get(anyString())).thenReturn(path);
        when(criteriaBuilder.equal(any(Path.class), any(Class.class))).thenReturn(predicate);
        when(criteriaQuery.where(any(Predicate.class))).thenReturn(criteriaQuery);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockTickets);

        List<Ticket> tickets = ticketDao.findByPassenger(mockPassenger);

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockTickets, tickets);
    }
}