package io.codeforall.finalcall.service;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;

import java.util.List;

public interface FlightService {

    Flight get(String code);

    Flight save(Flight flight);

    void delete(String code);

    List<Flight> list();

    Flight getNextFrom(Airport airport);

    Flight getNextFromTo(Airport departure, Airport destination);
}
