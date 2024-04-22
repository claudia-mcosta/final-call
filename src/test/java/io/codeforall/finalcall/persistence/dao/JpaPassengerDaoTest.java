package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.dao.jpa.JpaPassengerDao;
import io.codeforall.finalcall.persistence.model.Passenger;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class JpaPassengerDaoTest {

    private JpaPassengerDao passengerDao;
    private EntityManager em;

    @Before
    public void setup() {

        em = mock(EntityManager.class);

        passengerDao = new JpaPassengerDao();
        passengerDao.setEm(em);
    }

    @Test
    public void testFindAll() {

        List<Passenger> mockPassengers = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);

        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Passenger.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockPassengers);

        List<Passenger> passengers = passengerDao.findAll();

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockPassengers, passengers);
    }

    @Test
    public void testFindById() {

        String id = "123456789";
        Passenger mockPassenger = mock(Passenger.class);

        when(em.find(Passenger.class, id)).thenReturn(mockPassenger);

        Passenger passenger = passengerDao.findById(id);

        verify(em, times(1)).find(Passenger.class, id);
        assertEquals(mockPassenger, passenger);
    }

    @Test
    public void testSaveOrUpdate() {

        Passenger mockPassenger = mock(Passenger.class);

        when(em.merge(mockPassenger)).thenReturn(mockPassenger);

        Passenger passenger = passengerDao.saveOrUpdate(mockPassenger);

        verify(em, times(1)).merge(mockPassenger);
        assertEquals(mockPassenger, passenger);
    }

    @Test
    public void testDelete() {

        String id = "123456789";
        Passenger mockPassenger = mock(Passenger.class);

        when(em.find(Passenger.class, id)).thenReturn(mockPassenger);

        passengerDao.delete(id);

        verify(em, times(1)).find(Passenger.class, id);
        verify(em, times(1)).remove(mockPassenger);
    }
}