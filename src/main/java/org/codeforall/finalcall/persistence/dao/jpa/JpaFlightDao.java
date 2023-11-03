package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.persistence.dao.FlightDao;

public class JpaFlightDao extends GenericJpaDao<Flight, String> implements FlightDao {

    public JpaFlightDao() {
        super(Flight.class);
    }
}