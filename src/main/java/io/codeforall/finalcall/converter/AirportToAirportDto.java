package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.AirportDto;
import io.codeforall.finalcall.persistence.model.Airport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirportToAirportDto {

    public List<AirportDto> convert(List<Airport> airports) {

        return airports.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public AirportDto convert(Airport airport) {

        AirportDto airportDto = new AirportDto();

        airportDto.setCode(airport.getCode());
        airportDto.setName(airport.getName());
        airportDto.setCity(airport.getCity());
        airportDto.setCountry(airport.getCountry());

        return airportDto;
    }
}
