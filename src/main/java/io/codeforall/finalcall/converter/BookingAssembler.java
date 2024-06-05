package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.BookingDto;
import io.codeforall.finalcall.command.FlightDto;
import io.codeforall.finalcall.command.PassengerDto;
import io.codeforall.finalcall.command.TicketDto;
import io.codeforall.finalcall.factory.TicketFactory;
import io.codeforall.finalcall.persistence.model.Booking;
import io.codeforall.finalcall.persistence.model.Flight;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import io.codeforall.finalcall.service.AirportService;
import io.codeforall.finalcall.service.FlightService;
import io.codeforall.finalcall.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingAssembler {

    private TicketToTicketDto ticketToTicketDto;
    private PassengerToPassengerDto passengerToPassengerDto;
    private FlightToFlightDto flightToFlightDto;
    private TicketDtoToTicket ticketDtoToTicket;
    private PassengerDtoToPassenger passengerDtoToPassenger;
    private FlightDtoToFlight flightDtoToFlight;

    @Autowired
    public void setTicketToTicketDto(TicketToTicketDto ticketToTicketDto) {
        this.ticketToTicketDto = ticketToTicketDto;
    }

    @Autowired
    public void setPassengerToPassengerDto(PassengerToPassengerDto passengerToPassengerDto) {
        this.passengerToPassengerDto = passengerToPassengerDto;
    }

    @Autowired
    public void setFlightToFlightDto(FlightToFlightDto flightToFlightDto) {
        this.flightToFlightDto = flightToFlightDto;
    }

    @Autowired
    public void setTicketDtoToTicket(TicketDtoToTicket ticketDtoToTicket) {
        this.ticketDtoToTicket = ticketDtoToTicket;
    }

    @Autowired
    public void setPassengerDtoToPassenger(PassengerDtoToPassenger passengerDtoToPassenger) {
        this.passengerDtoToPassenger = passengerDtoToPassenger;
    }

    @Autowired
    public void setFlightDtoToFlight(FlightDtoToFlight flightDtoToFlight) {
        this.flightDtoToFlight = flightDtoToFlight;
    }

    public Booking createBooking(BookingDto bookingDto) {

        Booking booking = new Booking();
        createTickets(bookingDto.getTickets(), booking);

        return booking;
    }

    private void createTickets(List<TicketDto> ticketDtos, Booking booking) {

        for(TicketDto ticketDto : ticketDtos) {

            Ticket ticket = ticketDtoToTicket.convert(ticketDto);

            createFlight(ticketDto.getFlight(), ticket);
            createPassenger(ticketDto.getPassenger(), ticket);

            booking.addTicket(ticket);
        }
    }

    private void createPassenger(PassengerDto passengerDto, Ticket ticket) {

        Passenger passenger = passengerDtoToPassenger.convert(passengerDto);
        ticket.setPassenger(passenger);
    }

    private void createFlight(FlightDto flightDto, Ticket ticket) {

        Flight flight = flightDtoToFlight.convert(flightDto);
        ticket.setFlight(flight);
    }

    public BookingDto createBookingDto(Booking booking) {

        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());

        createTicketDtos(booking.getTickets(), bookingDto);

        return bookingDto;
    }

    private void createTicketDtos(List<Ticket> tickets, BookingDto bookingDto) {

        List<TicketDto> ticketDtos = new ArrayList<>();

        for(Ticket ticket : tickets) {

            TicketDto ticketDto = ticketToTicketDto.convert(ticket);

            createFlightDto(ticket.getFlight(), ticketDto);
            createPassengerDto(ticket.getPassenger(), ticketDto);

            ticketDtos.add(ticketDto);
        }

        bookingDto.setTickets(ticketDtos);
    }

    private void createPassengerDto(Passenger passenger, TicketDto ticketDto) {

        PassengerDto passengerDto = passengerToPassengerDto.convert(passenger);
        ticketDto.setPassenger(passengerDto);
    }

    private void createFlightDto(Flight flight, TicketDto ticketDto) {

        FlightDto flightDto = flightToFlightDto.convert(flight);
        ticketDto.setFlight(flightDto);
    }
}
