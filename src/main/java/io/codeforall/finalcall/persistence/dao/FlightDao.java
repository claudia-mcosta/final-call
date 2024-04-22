package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;

public interface FlightDao extends Dao<Flight, String> {
    Flight getNextFrom(Airport airport);
    Flight getNextFromTo(Airport departure, Airport destination);
}
