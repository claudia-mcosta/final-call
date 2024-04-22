package org.codeforall.finalcall.persistence.dao;

import org.codeforall.finalcall.model.Airport;
import org.codeforall.finalcall.model.Flight;

public interface FlightDao extends Dao<Flight, String> {
    Flight getNextFrom(Airport airport);
    Flight getNextFromTo(Airport departure, Airport destination);
}
