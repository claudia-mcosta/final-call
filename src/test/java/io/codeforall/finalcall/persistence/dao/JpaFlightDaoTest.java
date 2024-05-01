package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.dao.jpa.JpaFlightDao;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class JpaFlightDaoTest {

    private JpaFlightDao flightDao;
    private EntityManager em;

    @Before
    public void setup() {

        em = mock(EntityManager.class);

        flightDao = new JpaFlightDao();
        flightDao.setEm(em);
    }

    @Test
    public void testFindAll() {

        List<Flight> mockFlights = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Flight.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockFlights);

        List<Flight> flights = flightDao.findAll();

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockFlights, flights);
    }

    @Test
    public void testFindById() {

        String id = "AB123";
        Flight mockFlight = mock(Flight.class);

        when(em.find(Flight.class, id)).thenReturn(mockFlight);

        Flight flight = flightDao.findById(id);

        verify(em, times(1)).find(Flight.class, id);
        assertEquals(mockFlight, flight);
    }

    @Test
    public void testSaveOrUpdate() {

        Flight mockFlight = mock(Flight.class);

        when(em.merge(mockFlight)).thenReturn(mockFlight);

        Flight flight = flightDao.saveOrUpdate(mockFlight);

        verify(em, times(1)).merge(mockFlight);
        assertEquals(mockFlight, flight);
    }

    @Test
    public void testDelete() {

        String id = "AB123";
        Flight mockFlight = mock(Flight.class);

        when(em.find(Flight.class, id)).thenReturn(mockFlight);

        flightDao.delete(id);

        verify(em,times(1)).find(Flight.class, id);
        verify(em, times(1)).remove(mockFlight);
    }

    @Test
    public void testGetNextFrom() {

        // TODO -> This seems excessive. Is there a better way to test this method?

        Airport mockAirport = mock(Airport.class);
        Flight mockFlight = mock(Flight.class);
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        Root mockRoot = mock(Root.class);
        Path mockPath = mock(Path.class);
        Order mockOrder = mock(Order.class);
        Predicate mockPredicate = mock(Predicate.class);
        Expression mockExpression = mock(Expression.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Flight.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Flight.class)).thenReturn(mockRoot);
        when(mockRoot.get(anyString())).thenReturn(mockPath);
        when(criteriaBuilder.equal(any(Path.class), any(Airport.class))).thenReturn(mockPredicate);
        when(criteriaBuilder.greaterThan(any(Path.class), any(Expression.class))).thenReturn(mockPredicate);
        when(criteriaBuilder.currentTimestamp()).thenReturn(mockExpression);
        when(criteriaBuilder.asc(any(Expression.class))).thenReturn(mockOrder);
        when(criteriaQuery.where(any(Predicate.class), any(Predicate.class))).thenReturn(criteriaQuery);
        when(criteriaQuery.orderBy(any(Order.class))).thenReturn(criteriaQuery);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.setMaxResults(1)).thenReturn(typedQuery);
        when(typedQuery.getSingleResult()).thenReturn(mockFlight);

        Flight flight = flightDao.getNextFrom(mockAirport);

        verify(typedQuery, times(1)).setMaxResults(1);
        verify(typedQuery, times(1)).getSingleResult();
        assertEquals(mockFlight, flight);
    }
}
