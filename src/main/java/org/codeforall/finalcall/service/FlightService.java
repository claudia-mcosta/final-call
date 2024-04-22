package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.Airport;
import org.codeforall.finalcall.model.Flight;

import java.util.List;

public interface FlightService {

    Flight get(String code);

    Flight save(Flight flight);

    void delete(String code);

    List<Flight> list();

    Flight getNextFrom(Airport airport);

    Flight getNextFromTo(Airport departure, Airport destination);
}
