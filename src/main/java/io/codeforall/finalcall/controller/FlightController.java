package io.codeforall.finalcall.controller;

import io.codeforall.finalcall.command.FlightDto;
import io.codeforall.finalcall.converter.FlightDtoToFlight;
import io.codeforall.finalcall.converter.FlightToFlightDto;
import io.codeforall.finalcall.exceptions.AirportNotFoundException;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.service.AirportService;
import io.codeforall.finalcall.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private FlightService flightService;
    private AirportService airportService;
    private FlightToFlightDto flightToFlightDto;
    private FlightDtoToFlight flightDtoToFlight;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @Autowired
    public void setFlightToFlightDto(FlightToFlightDto flightToFlightDto) {
        this.flightToFlightDto = flightToFlightDto;
    }

    @Autowired
    public void setFlightDtoToFlight(FlightDtoToFlight flightDtoToFlight) {
        this.flightDtoToFlight = flightDtoToFlight;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/origin/{code}")
    public ResponseEntity<FlightDto> getNextFlightFrom(@PathVariable String code) {

        Airport airport = airportService.get(code);
        Flight flight = flightService.getNextFrom(airport);

        FlightDto flightDto = flightToFlightDto.convert(flight);

        return new ResponseEntity<>(flightDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/origin/{originCode}/destination/{destinationCode}")
    public ResponseEntity<FlightDto> getNextFlightFromTo(@PathVariable String originCode, @PathVariable String destinationCode) {

        Airport origin = airportService.get(originCode);
        Airport destination = airportService.get(destinationCode);
        Flight flight = flightService.getNextFromTo(origin, destination);

        FlightDto flightDto = flightToFlightDto.convert(flight);

        return new ResponseEntity<>(flightDto, HttpStatus.OK);
    }
}
