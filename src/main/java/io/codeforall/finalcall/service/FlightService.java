package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.FlightNotFoundException;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;

import java.util.List;

public interface FlightService {

    Flight get(String code);

    Flight save(Flight flight);

    void delete(String code) throws FlightNotFoundException;

    List<Flight> list();

    Flight getNextFlight(Airport airport);

    Flight getNextFlight(Airport departure, Airport destination);
}
