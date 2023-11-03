package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.Airport;
import org.codeforall.finalcall.persistence.dao.AirportDao;
import org.codeforall.finalcall.persistence.dao.PassengerDao;
import org.codeforall.finalcall.persistence.dao.TicketDao;

import java.util.List;

public class AirportServiceImpl implements AirportService {

    private AirportDao airportDao;

    public void setAirportDao(AirportDao airportDao) {
        this.airportDao = airportDao;
    }


    @Override
    public Airport get(String code) {
        return airportDao.findById(code);
    }

    @Override
    public Airport save(Airport airport) {
        return airportDao.saveOrUpdate(airport);
    }

    @Override
    public void delete(String code) {
        airportDao.delete(code);
    }

    @Override
    public List<Airport> list() {
        return airportDao.findAll();
    }

    //STILL MISSING IMPL FROM THIS LINE BELOW
    @Override
    public List<Airport> listAvailable() {
        return airportDao.listAvailable();
    }

    @Override
    public List<Airport> listAvailableFrom(String code) {
        return airportDao.listAvailableFrom(code);
    }
}
