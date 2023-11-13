package org.codeforall.finalcall.persistence.dao;

import org.codeforall.finalcall.persistence.model.Airport;
import org.codeforall.finalcall.persistence.model.Flight;

public interface FlightDao extends Dao<Flight, String> {
    Flight getNextFrom(Airport airport);
    Flight getNextFromTo(Airport departure, Airport destination);
}
