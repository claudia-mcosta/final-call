package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.persistence.model.Passenger;
import org.codeforall.finalcall.persistence.dao.PassengerDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPassengerDao extends GenericJpaDao<Passenger, String> implements PassengerDao {

    public JpaPassengerDao() {
        super(Passenger.class);
    }
}