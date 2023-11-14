package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.model.Airport;

import java.util.List;

public interface AirportDao extends Dao<Airport, String> {

    List<Airport> listFrom(String code);
}