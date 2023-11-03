package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.persistence.dao.FlightDao;

import java.util.List;

public class FlightServiceImpl implements FlightService {

    private FlightDao flightDao;

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
    public Flight getNextFrom(String departureAirportCode) {
        return flightDao.getNextFrom(departureAirportCode);
    }

    @Override
    public Flight getNextFromTo(String departureAirportCode, String destinationAirportCode) {
        return flightDao.getNextFromTo(departureAirportCode,destinationAirportCode);
    }
}
