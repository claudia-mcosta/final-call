package io.codeforall.finalcall.service;

import io.codeforall.finalcall.persistence.model.Airport;

import java.util.List;

public interface AirportService {

    Airport get(String code);

    Airport save(Airport airport);

    void delete(String code);

    List<Airport> list();

    List<Airport> listFrom(String code);
}
