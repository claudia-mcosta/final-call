package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.model.Airport;
import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.persistence.dao.AirportDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.*;
import java.util.List;

public class JpaAirportDao extends GenericJpaDao<Airport, String> implements AirportDao {

    public JpaAirportDao() {
        super(Airport.class);
    }

    @Override
    public List<Airport> listFrom(String code) {

        String jpql = "SELECT a " +
                      "FROM Airport a " +
                      "JOIN Flight b " +
                      "ON a.code = b.destination " +
                      "AND b.departure = :departureAirportCode";

        TypedQuery<Airport> query = em.createQuery(jpql, Airport.class);
        query.setParameter("departureAirportCode", findById(code));

        return query.getResultList();

        /*
        SELECT airports.*
        FROM airports
        JOIN flights
        ON flights.destination_airport_code = airports.code
        AND flights.departure_airport_code = "";
        */

        /*
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Airport> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Metamodel m = em.getMetamodel();
        EntityType<Flight> Flight_ = m.entity(Flight.class);

        Root<Airport> root = criteriaQuery.from(Airport.class);
        Join<Airport, Flight> flight = root.join();

        criteriaQuery.where(criteriaBuilder.equal(root.get("departure"), findById(code)));

        return em.createQuery(criteriaQuery).getResultList();
        */
    }
}
