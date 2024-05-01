package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.FlightDto;
import io.codeforall.finalcall.persistence.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightToFlightDto {

    public FlightDto convert(Flight flight) {

        FlightDto flightDto = new FlightDto();

        flightDto.setCode(flight.getCode());
        flightDto.setCarrier(flight.getCarrier());
        flightDto.setOriginAirportCode(flight.getOrigin().getCode());
        flightDto.setDestinationAirportCode(flight.getDestination().getCode());
        flightDto.setDepartureTime(flight.getDepartureTime());
        flightDto.setDuration(flight.getDuration());

        return flightDto;
    }
}
