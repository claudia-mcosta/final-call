package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.model.Airport;
import org.codeforall.finalcall.persistence.dao.AirportDao;

public class JpaAirportDao extends GenericJpaDao<Airport, String> implements AirportDao {

    public JpaAirportDao() {
        super(Airport.class);
    }
}