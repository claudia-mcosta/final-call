package io.codeforall.finalcall.persistence.dao.jpa;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.dao.FlightDao;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class JpaFlightDao extends GenericJpaDao<Flight, String> implements FlightDao {

    public JpaFlightDao() {
        super(Flight.class);
    }

    public Flight getNextFlight(Airport origin) {

        /*
        String jpql = "SELECT f FROM Flight f " +
                "WHERE f.origin = :airport " +
                "AND f.departureTime > CURRENT_TIMESTAMP " +
                "ORDER BY f.departureTime ASC";

        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter("airport", origin);
        query.setMaxResults(1);

        return query.getSingleResult();
        */

        // Type safe query
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Root<Flight> root = criteriaQuery.from(modelType);

        criteriaQuery.where(criteriaBuilder.equal(root.get("origin"), origin),
                            criteriaBuilder.greaterThan(root.get("departureTime"), criteriaBuilder.currentTimestamp()))
                     .orderBy(criteriaBuilder.asc(root.get("departureTime")));

        // TODO -> Is it better to add .setMaxResults(1) so we don't get all of the results? .getSingleResult() throws exception when there are no results.
        return em.createQuery(criteriaQuery).getResultStream().findFirst().orElse(null);
    }

    @Override
    public Flight getNextFlight(Airport origin, Airport destination) {

        /*
        String jpql = "SELECT f FROM Flight f " +
                "WHERE f.origin = :origin " +
                "AND f.destination = :destination " +
                "AND f.departureTime > CURRENT_TIMESTAMP " +
                "ORDER BY f.departureTime ASC";

        TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
        query.setParameter("origin", origin);
        query.setParameter("destination", destination);
        query.setMaxResults(1);

        return query.getSingleResult();
        */

        // Type safe query
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Root<Flight> root = criteriaQuery.from(modelType);

        criteriaQuery.where(criteriaBuilder.equal(root.get("origin"), origin),
                            criteriaBuilder.equal(root.get("destination"), destination),
                            criteriaBuilder.greaterThan(root.get("departureTime"), criteriaBuilder.currentTimestamp()))
                     .orderBy(criteriaBuilder.asc(root.get("departureTime")));

        // TODO -> Is it better to add .setMaxResults(1) so we don't get all of the results? .getSingleResult() throws exception when there are no results.
        return em.createQuery(criteriaQuery).getResultStream().findFirst().orElse(null);
    }
}