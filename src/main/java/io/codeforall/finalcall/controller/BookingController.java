package io.codeforall.finalcall.controller;

import io.codeforall.finalcall.command.BookingDto;
import io.codeforall.finalcall.exceptions.UserNotFoundException;
import io.codeforall.finalcall.persistence.model.Booking;
import io.codeforall.finalcall.service.BookingService;
import io.codeforall.finalcall.service.UserService;
import io.codeforall.finalcall.converter.BookingAssembler;

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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class BookingController {

    private BookingService bookingService;
    private UserService userService;
    private BookingAssembler bookingAssembler;

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBookingAssembler(BookingAssembler bookingAssembler) {
        this.bookingAssembler = bookingAssembler;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, path = {"/{uid}/booking/{id}"})
    public ResponseEntity<BookingDto> showBooking(@PathVariable Integer id, @PathVariable Integer uid) {

        Booking booking = bookingService.get(id);

        if (booking == null || !booking.getUser().getId().equals(uid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookingAssembler.createBookingDto(booking), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = {"/{uid}/booking"})
    public ResponseEntity<?> addBooking(@Valid @RequestBody BookingDto bookingDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder, @PathVariable Integer uid) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {

            Booking savedBooking = userService.addBooking(uid, bookingAssembler.createBooking(bookingDto));

            UriComponents uriComponents = uriComponentsBuilder.path("/api/" + uid + "/booking/" + savedBooking.getId()).build();

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
