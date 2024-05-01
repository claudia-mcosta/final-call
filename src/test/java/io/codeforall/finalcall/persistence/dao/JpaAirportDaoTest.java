package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.dao.jpa.JpaAirportDao;
import io.codeforall.finalcall.persistence.model.Airport;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class JpaAirportDaoTest {

    private JpaAirportDao airportDao;
    private EntityManager em;

    @Before
    public void setup() {

        em = mock(EntityManager.class);

        airportDao = new JpaAirportDao();
        airportDao.setEm(em);
    }

    @Test
    public void testFindAll() {

        List<Airport> mockAirports = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Airport.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockAirports);

        List<Airport> airports = airportDao.findAll();

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockAirports, airports);
    }

    @Test
    public void testFindById() {

        String id = "LIS";
        Airport mockAirport = mock(Airport.class);

        when(em.find(Airport.class, id)).thenReturn(mockAirport);

        Airport airport = airportDao.findById(id);

        verify(em, times(1)).find(Airport.class, id);
        assertEquals(mockAirport, airport);
    }

    @Test
    public void testSaveOrUpdate() {

        Airport mockAirport = mock(Airport.class);

        when(em.merge(mockAirport)).thenReturn(mockAirport);

        Airport airport = airportDao.saveOrUpdate(mockAirport);

        verify(em, times(1)).merge(mockAirport);
        assertEquals(mockAirport, airport);
    }

    @Test
    public void testDelete() {

        String id = "LIS";
        Airport mockAirport = mock(Airport.class);

        when(em.find(Airport.class, id)).thenReturn(mockAirport);

        airportDao.delete(id);

        verify(em, times(1)).find(Airport.class, id);
        verify(em, times(1)).remove(mockAirport);
    }

    @Test
    public void testListFrom() {

        List<Airport> mockAirports = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Airport.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockAirports);
        when(em.createQuery(anyString(), any(Class.class))).thenReturn(typedQuery);
        when(typedQuery.setParameter(anyString(), any(Class.class))).thenReturn(typedQuery);

        List<Airport> airports = airportDao.listFrom("LIS");

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockAirports, airports);
    }
}
