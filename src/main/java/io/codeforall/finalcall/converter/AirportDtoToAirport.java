package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.AirportDto;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirportDtoToAirport {

    private AirportService airportService;

    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    public Airport convert(AirportDto airportDto) {

        Airport airport = airportDto.getCode() != null ? airportService.get(airportDto.getCode()) : new Airport();

        airport.setCode(airportDto.getCode());
        airport.setName(airportDto.getName());
        airport.setCity(airportDto.getCity());
        airport.setCountry(airportDto.getCountry());

        return airport;
    }
}
