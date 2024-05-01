package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.FlightNotFoundException;
import io.codeforall.finalcall.exceptions.PassengerNotFoundException;
import io.codeforall.finalcall.exceptions.TicketNotFoundException;
import io.codeforall.finalcall.persistence.dao.PassengerDao;
import io.codeforall.finalcall.persistence.dao.TicketDao;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerDao passengerDao;

    @Autowired
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    public Passenger get(Integer id) {
        return passengerDao.findById(id);
    }

    @Transactional
    @Override
    public Passenger save(Passenger passenger) {
        return passengerDao.saveOrUpdate(passenger);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws PassengerNotFoundException {

        Optional.ofNullable(passengerDao.findById(id))
                .orElseThrow(PassengerNotFoundException::new);

        passengerDao.delete(id);
    }
}
