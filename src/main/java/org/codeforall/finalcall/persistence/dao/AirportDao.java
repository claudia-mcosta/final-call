package org.codeforall.finalcall.persistence.dao;

import org.codeforall.finalcall.model.Airport;

import java.util.List;

public interface AirportDao extends Dao<Airport, String> {

    List<Airport> listFrom(String code);
}