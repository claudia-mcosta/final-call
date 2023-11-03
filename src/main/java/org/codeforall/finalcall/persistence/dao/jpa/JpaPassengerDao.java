package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.persistence.dao.PassengerDao;

public class JpaPassengerDao extends GenericJpaDao<Passenger, String> implements PassengerDao {

    public JpaPassengerDao() {
        super(Passenger.class);
    }
}