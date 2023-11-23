package io.codeforall.finalcall.controller;

import io.codeforall.finalcall.command.PassengerDto;
import io.codeforall.finalcall.converter.PassengerDtoToPassenger;
import io.codeforall.finalcall.converter.PassengerToPassengerDto;
import io.codeforall.finalcall.exceptions.AssociationExistsException;
import io.codeforall.finalcall.exceptions.PassengerNotFoundException;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    private PassengerService passengerService;
    private PassengerToPassengerDto passengerToPassengerDto;
    private PassengerDtoToPassenger passengerDtoToPassenger;

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    public void setPassengerToPassengerDto(PassengerToPassengerDto passengerToPassengerDto) {
        this.passengerToPassengerDto = passengerToPassengerDto;
    }

    @Autowired
    public void setPassengerDtoToPassenger(PassengerDtoToPassenger passengerDtoToPassenger) {
        this.passengerDtoToPassenger = passengerDtoToPassenger;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<PassengerDto> showPassenger(@PathVariable String id) {

        Passenger passenger = passengerService.get(id);

        if (passenger == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(passengerToPassengerDto.convert(passenger), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addPassenger(@Valid @RequestBody PassengerDto passengerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || passengerService.get(passengerDto.getNationalId()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Passenger savedPassenger = passengerService.save(passengerDtoToPassenger.convert(passengerDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/passenger/" + savedPassenger.getNationalId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<PassengerDto> editPassenger(@Valid @RequestBody PassengerDto passengerDto, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (passengerDto.getNationalId() != null && !passengerDto.getNationalId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (passengerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        passengerDto.setNationalId(id);

        passengerService.save(passengerDtoToPassenger.convert(passengerDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<PassengerDto> deletePassenger(@PathVariable String id) {

        try {
            passengerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (PassengerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
