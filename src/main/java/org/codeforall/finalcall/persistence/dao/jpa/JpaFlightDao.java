package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.persistence.dao.FlightDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaFlightDao extends GenericJpaDao<Flight, String> implements FlightDao {

    public JpaFlightDao() {
        super(Flight.class);
    }

    public Flight getNextFrom(String departureAirportCode) {

        String jpql = "SELECT f FROM Flight f " +
                "WHERE f.departure = :departureAirportCode " +
                "AND f.departureTime > CURRENT_TIMESTAMP " +
                "ORDER BY f.departureTime ASC";

        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter("departureAirportCode", departureAirportCode);
        query.setMaxResults(1);

        Flight nextFlight = query.getSingleResult();
        return nextFlight;
    }

    @Override
    public Flight getNextFromTo(String departureAirportCode, String destinationAirportCode) {
        String jpql = "SELECT f FROM Flight f " +
                "WHERE f.departure = :departureAirportCode " +
                "AND f.destination = :destinationAirportCode " +
                "AND f.departureTime > CURRENT_TIMESTAMP " +
                "ORDER BY f.departureTime ASC";

        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter("departureAirportCode", departureAirportCode);
        query.setParameter("destinationAirportCode", destinationAirportCode);
        query.setMaxResults(1);

        Flight earliestNextFlight = query.getSingleResult();
        return earliestNextFlight;
    }

}