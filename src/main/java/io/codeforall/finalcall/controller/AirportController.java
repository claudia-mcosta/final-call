package io.codeforall.finalcall.controller;

import io.codeforall.finalcall.command.AirportDto;
import io.codeforall.finalcall.converter.AirportToAirportDto;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/airport")
public class AirportController {

    private AirportService airportService;
    private AirportToAirportDto airportToAirportDto;

    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @Autowired
    public void setAirportToAirportDto(AirportToAirportDto airportToAirportDto) {
        this.airportToAirportDto = airportToAirportDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<AirportDto>> listAirports() {

        List<Airport> airports = airportService.list();

        List<AirportDto> airportDtos = airportToAirportDto.convert(airports);

        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/origin/{aid}")
    public ResponseEntity<List<AirportDto>> listDestinationAirports(@PathVariable String aid) {

        List<Airport> airports = airportService.listFrom(aid);

        List<AirportDto> airportDtos = airportToAirportDto.convert(airports);

        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }
}