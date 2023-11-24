package io.codeforall.finalcall.controller;

import io.codeforall.finalcall.command.FlightDto;
import io.codeforall.finalcall.converter.FlightToFlightDto;
import io.codeforall.finalcall.converter.FlightDtoToFlight;
import io.codeforall.finalcall.exceptions.FlightNotFoundException;
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

import javax.validation.Valid;

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

    @RequestMapping(method = RequestMethod.GET, path = "/select")
    public ResponseEntity<FlightDto> getNextFlight(@RequestParam String origin, @RequestParam(defaultValue = "ANY") String destination) {

        if (origin.equals(destination))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Airport originAirport = airportService.get(origin);
        Airport destinationAirport = airportService.get(destination);

        Flight flight = (destinationAirport != null ? flightService.getNextFlight(originAirport, destinationAirport) : flightService.getNextFlight(originAirport));

        if (flight == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        FlightDto flightDto = flightToFlightDto.convert(flight);

        return new ResponseEntity<>(flightDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addFlight(@Valid @RequestBody FlightDto flightDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || flightDto.getOriginAirportCode().equals(flightDto.getDestinationAirportCode()) || flightService.get(flightDto.getCode()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Flight savedFlight = flightService.save(flightDtoToFlight.convert(flightDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/flight/" + savedFlight.getCode()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<FlightDto> editFlight(@Valid @RequestBody FlightDto flightDto, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors() || flightDto.getCode() != null && !flightDto.getCode().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (flightService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        flightDto.setCode(id);

        flightService.save(flightDtoToFlight.convert(flightDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<FlightDto> deleteFlight(@PathVariable String id) {

        try {
            flightService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (FlightNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}