package io.codeforall.finalcall.persistence.dao.jpa;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.dao.AirportDao;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaAirportDao extends GenericJpaDao<Airport, String> implements AirportDao {

    public JpaAirportDao() {
        super(Airport.class);
    }

    @Override
    public List<Airport> listFrom(String origin) {

        String jpql = "SELECT a " +
                      "FROM Airport a " +
                      "JOIN Flight b " +
                      "ON b.destination = a.code " +
                      "AND b.origin = :originAirportCode";

        TypedQuery<Airport> query = em.createQuery(jpql, Airport.class);
        query.setParameter("originAirportCode", findById(origin));

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
