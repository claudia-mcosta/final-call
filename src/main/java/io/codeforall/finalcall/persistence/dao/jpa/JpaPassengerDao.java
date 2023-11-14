package io.codeforall.finalcall.persistence.dao.jpa;

import io.codeforall.finalcall.persistence.dao.PassengerDao;
import io.codeforall.finalcall.persistence.model.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPassengerDao extends GenericJpaDao<Passenger, String> implements PassengerDao {

    public JpaPassengerDao() {
        super(Passenger.class);
    }
}