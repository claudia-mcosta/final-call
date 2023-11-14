package io.codeforall.finalcall.persistence.dao.jpa;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.dao.FlightDao;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class JpaFlightDao extends GenericJpaDao<Flight, String> implements FlightDao {

    public JpaFlightDao() {
        super(Flight.class);
    }

    public Flight getNextFrom(Airport airport) {

        /*
        String jpql = "SELECT f FROM Flight f " +
                "WHERE f.departure = :airport " +
                "AND f.departureTime > CURRENT_TIMESTAMP " +
                "ORDER BY f.departureTime ASC";

        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter("airport", airport);
        query.setMaxResults(1);

        return query.getSingleResult();
        */

        // Type safe query
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Root<Flight> root = criteriaQuery.from(modelType);

        criteriaQuery.where(criteriaBuilder.equal(root.get("departure"), airport),
                            criteriaBuilder.greaterThan(root.get("departureTime"), criteriaBuilder.currentTimestamp()))
                     .orderBy(criteriaBuilder.asc(root.get("departureTime")));

        return em.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();

    }

    @Override
    public Flight getNextFromTo(Airport departure, Airport destination) {

        /*
        String jpql = "SELECT f FROM Flight f " +
                "WHERE f.departure = :departure " +
                "AND f.destination = :destination " +
                "AND f.departureTime > CURRENT_TIMESTAMP " +
                "ORDER BY f.departureTime ASC";

        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter("departureAirportCode", departure);
        query.setParameter("destinationAirportCode", destination);
        query.setMaxResults(1);

        return query.getSingleResult();
        */

        // Type safe query
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Root<Flight> root = criteriaQuery.from(modelType);

        criteriaQuery.where(criteriaBuilder.equal(root.get("departure"), departure),
                            criteriaBuilder.equal(root.get("destination"), destination),
                            criteriaBuilder.greaterThan(root.get("departureTime"), criteriaBuilder.currentTimestamp()))
                     .orderBy(criteriaBuilder.asc(root.get("departureTime")));

        return em.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
    }
}