package io.codeforall.finalcall.persistence.dao.jpa;

import io.codeforall.finalcall.persistence.dao.BookingDao;
import io.codeforall.finalcall.persistence.model.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBookingDao extends GenericJpaDao<Booking, Integer> implements BookingDao {

    public JpaBookingDao() {
        super(Booking.class);
    }
}