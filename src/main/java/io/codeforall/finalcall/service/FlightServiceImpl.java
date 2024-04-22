package io.codeforall.finalcall.service;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Flight save(Flight flight) {
        return flightDao.saveOrUpdate(flight);
    }

    @Override
    public void delete(String code) {
        flightDao.delete(code);
    }

    @Override
    public List<Flight> list() {
        return flightDao.findAll();
    }

    @Override
    public Flight getNextFrom(Airport airport) {
        return flightDao.getNextFrom(airport);
    }

    @Override
    public Flight getNextFromTo(Airport departure, Airport destination) {
        return flightDao.getNextFromTo(departure, destination);
    }
}