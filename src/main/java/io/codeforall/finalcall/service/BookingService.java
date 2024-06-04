package io.codeforall.finalcall.service;

import io.codeforall.finalcall.persistence.model.Booking;

import java.util.List;

public interface BookingService {

    Booking get(Integer id);

    Booking save(Booking booking);

    void delete(Integer id);

    List<Booking> list();
}
