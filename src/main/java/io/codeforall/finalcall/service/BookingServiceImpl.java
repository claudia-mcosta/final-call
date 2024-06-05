package io.codeforall.finalcall.service;

import io.codeforall.finalcall.persistence.dao.BookingDao;
import io.codeforall.finalcall.persistence.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;

    @Autowired
    public void setBookingDao(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public Booking get(Integer id) {
        return bookingDao.findById(id);
    }

    @Transactional
    @Override
    public Booking save(Booking booking) {
        return bookingDao.saveOrUpdate(booking);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        bookingDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Booking> list() {
        return bookingDao.findAll();
    }
}
