package io.codeforall.finalcall.persistence.dao;

import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;

public interface FlightDao extends Dao<Flight, String> {

    Flight getNextFlight(Airport origin);

    Flight getNextFlight(Airport origin, Airport destination);
}
