package io.codeforall.finalcall.controller;

import io.codeforall.finalcall.command.TicketDto;
import io.codeforall.finalcall.converter.TicketDtoToTicket;
import io.codeforall.finalcall.converter.TicketToTicketDto;
import io.codeforall.finalcall.exceptions.TicketNotFoundException;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.service.PassengerService;
import io.codeforall.finalcall.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private TicketService ticketService;
    private PassengerService passengerService;
    private TicketToTicketDto ticketToTicketDto;
    private TicketDtoToTicket ticketDtoToTicket;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    public void setTicketToTicketDto(TicketToTicketDto ticketToTicketDto) {
        this.ticketToTicketDto = ticketToTicketDto;
    }

    @Autowired
    public void setTicketDtoToTicket(TicketDtoToTicket ticketDtoToTicket) {
        this.ticketDtoToTicket = ticketDtoToTicket;
    }
/*
    @RequestMapping(method = RequestMethod.GET, path = "/passenger/{pid}/flight/{fid}")
    public ResponseEntity<TicketDto> showTicket(@PathVariable String pid, @PathVariable String fid) {

        Passenger passenger = passengerService.get(pid);
        Flight flight = flightService.get(fid);

        Ticket ticket = ticketService.get(passenger, flight);

        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ticketToTicketDto.convert(ticket), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/passenger/{pid}")
    public ResponseEntity<List<TicketDto>> listTickets(@PathVariable String pid) {

        Passenger passenger = passengerService.get(pid);
        List<Ticket> ticket = passengerService.listTickets(passenger);

        if (ticket.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<TicketDto> ticketDtos = ticketToTicketDto.convert(ticket);

        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addTicket(@Valid @RequestBody TicketDto ticketDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        // Need to get the passenger for this ticket
        if (bindingResult.hasErrors() || ticketService.get(ticketDto.getNationalId()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ticket savedTicket = passengerService.buyTicket(ticketDtoToTicket.convert(ticketDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/ticket/" + savedTicket.getNationalId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());


        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    editTicket();

    @RequestMapping(method = RequestMethod.DELETE, path = "/passenger/{pid}/flight/{fid}")
    public ResponseEntity<TicketDto> deleteTicket(@PathVariable String pid, @PathVariable String fid) {

        try {
            passengerService.cancelTicket(pid, fid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (TicketNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 */
}