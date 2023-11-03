package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.model.Airport;
import org.codeforall.finalcall.persistence.dao.AirportDao;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaAirportDao extends GenericJpaDao<Airport, String> implements AirportDao {

    public JpaAirportDao() {
        super(Airport.class);
    }

    @Override
    public List<Airport> listAvailableFrom(String code) {

        String jpql = "SELECT a FROM Airport a " +
                "WHERE a.code <> :departureAirportCode";

        TypedQuery<Airport> query = em.createQuery(jpql, Airport.class);
        query.setParameter("departureAirportCode", code);

        List<Airport> availableAirports = query.getResultList();
        return availableAirports;
    }

    //DId not understand this method

    @Override
    public List<Airport> listAvailable() {
        return null;
    }
}