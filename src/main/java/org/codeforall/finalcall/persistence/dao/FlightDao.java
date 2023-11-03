package org.codeforall.finalcall.persistence.dao;

import org.codeforall.finalcall.model.Flight;

public interface FlightDao extends Dao<Flight, String> {
    Flight getNextFrom(String id);
    Flight getNextFromTo(String departureAirportCode, String destinationAirportCode);
}
