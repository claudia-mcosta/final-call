package io.codeforall.finalcall.service;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.dao.AirportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    @Transactional
    @Override
    public Airport save(Airport airport) {
        return airportDao.saveOrUpdate(airport);
    }

    @Transactional
    @Override
    public void delete(String code) {
        airportDao.delete(code);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Airport> list() {
        return airportDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Airport> listFrom(String code) {
        return airportDao.listFrom(code);
    }
}