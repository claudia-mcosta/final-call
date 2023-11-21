package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.FlightDto;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.service.AirportService;
import io.codeforall.finalcall.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightDtoToFlight {

    private FlightService flightService;
    private AirportService airportService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    public Flight convert(FlightDto flightDto) {

        Flight flight = flightService.get(flightDto.getCode());

        if(flight == null)
            flight = new Flight();

        flight.setCode(flightDto.getCode());
        flight.setCarrier(flightDto.getCarrier());
        flight.setDeparture(airportService.get(flightDto.getDepartureAirportCode()));
        flight.setDestination(airportService.get(flightDto.getDestinationAirportCode()));
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setDuration(flightDto.getDuration());

        return flight;
    }
}
