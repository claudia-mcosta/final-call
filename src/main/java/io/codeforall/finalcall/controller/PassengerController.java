package io.codeforall.finalcall.controller;

import io.codeforall.finalcall.command.PassengerDto;
import io.codeforall.finalcall.converter.PassengerDtoToPassenger;
import io.codeforall.finalcall.converter.PassengerToPassengerDto;
import io.codeforall.finalcall.exceptions.FinalCallException;
import io.codeforall.finalcall.exceptions.UserNotFoundException;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.User;
import io.codeforall.finalcall.service.PassengerService;
import io.codeforall.finalcall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class PassengerController {

    private PassengerService passengerService;
    private UserService userService;
    private PassengerToPassengerDto passengerToPassengerDto;
    private PassengerDtoToPassenger passengerDtoToPassenger;

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPassengerToPassengerDto(PassengerToPassengerDto passengerToPassengerDto) {
        this.passengerToPassengerDto = passengerToPassengerDto;
    }

    @Autowired
    public void setPassengerDtoToPassenger(PassengerDtoToPassenger passengerDtoToPassenger) {
        this.passengerDtoToPassenger = passengerDtoToPassenger;
    }

    // If passenger has more than 1 ticket, they show up more than once because of Hibernate's outer join. Possible solution: use Set instead of List in model.
    @Transactional
    @RequestMapping(method = RequestMethod.GET, path = {"/{uid}/passenger"})
    public ResponseEntity<List<PassengerDto>> listPassengers(@PathVariable Integer uid) {

        User user = userService.get(uid);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Passenger> passengers = userService.listPassengers(user);

        if (passengers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<PassengerDto> passengerDtos = passengerToPassengerDto.convert(passengers);

        return new ResponseEntity<>(passengerDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{uid}/passenger/{id}")
    public ResponseEntity<PassengerDto> showPassenger(@PathVariable Integer id, @PathVariable Integer uid) {

        Passenger passenger = passengerService.get(id);

        if (passenger == null || !passenger.getUser().getId().equals(uid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(passengerToPassengerDto.convert(passenger), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/{uid}/passenger"})
    public ResponseEntity<?> addPassenger(@Valid @RequestBody PassengerDto passengerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder, @PathVariable Integer uid) {

        if (bindingResult.hasErrors() || passengerDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {

            Passenger savedPassenger = userService.addPassenger(uid, passengerDtoToPassenger.convert(passengerDto));

            UriComponents uriComponents = uriComponentsBuilder.path("/api/" + uid + "/passenger/" + savedPassenger.getId()).build();

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{uid}/passenger/{id}")
    public ResponseEntity<PassengerDto> editPassenger(@Valid @RequestBody PassengerDto passengerDto, BindingResult bindingResult, @PathVariable Integer uid, @PathVariable Integer id) {

        if (bindingResult.hasErrors() || passengerDto.getId() != null && !passengerDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Passenger passenger = passengerService.get(id);

        if (passengerService.get(id) == null || !passenger.getUser().getId().equals(uid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        passengerDto.setId(id);

        passengerService.save(passengerDtoToPassenger.convert(passengerDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{uid}/passenger/{id}")
    public ResponseEntity<PassengerDto> deletePassenger(@PathVariable Integer uid, @PathVariable Integer id) {

        try {

            userService.deletePassenger(uid, id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (FinalCallException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
