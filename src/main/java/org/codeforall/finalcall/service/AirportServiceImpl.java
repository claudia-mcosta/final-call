package org.codeforall.finalcall.service;

import org.codeforall.finalcall.persistence.model.Airport;
import org.codeforall.finalcall.persistence.dao.AirportDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AirportServiceImpl implements AirportService {

    private AirportDao airportDao;

    @Autowired
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

    @Override
    public List<Airport> listFrom(String code) {
        return airportDao.listFrom(code);
    }
}