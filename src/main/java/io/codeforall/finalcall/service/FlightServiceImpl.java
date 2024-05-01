package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.FlightNotFoundException;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightDao flightDao;

    @Autowired
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Flight get(String code) {
        return flightDao.findById(code);
    }

    @Transactional
    @Override
    public Flight save(Flight flight) {
        return flightDao.saveOrUpdate(flight);
    }

    @Transactional
    @Override
    public void delete(String code) throws FlightNotFoundException {

        Optional.ofNullable(flightDao.findById(code))
                .orElseThrow(FlightNotFoundException::new);

        flightDao.delete(code);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Flight> list() {
        return flightDao.findAll();
    }

    @Override
    public Flight getNextFlight(Airport origin) {
        return flightDao.getNextFlight(origin);
    }

    @Override
    public Flight getNextFlight(Airport origin, Airport destination) {
        return flightDao.getNextFlight(origin, destination);
    }
}