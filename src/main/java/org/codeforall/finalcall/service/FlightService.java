package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.Flight;

import java.util.List;

public interface FlightService {

    Flight get(String code);

    Flight save(Flight flight);

    void delete(String code);

    List<Flight> list();

    Flight getNextFrom(String departureAirportCode);

    Flight getNextFromTo(String departureAirportCode, String destinationAirportCode);
}
