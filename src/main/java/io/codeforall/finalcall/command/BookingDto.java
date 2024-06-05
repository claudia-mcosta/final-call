package io.codeforall.finalcall.command;

import java.util.List;

public class BookingDto {

    private Integer id;
    private List<TicketDto> tickets;

    /*
     * Booking Id
     * Trip Start Date
     * Trip End Date
     *
     * Passengers
     *      Names
     *
     * Flights
     *      Origin
     *      Destination
     *      Departure
     *      Arrival
     *      Code
     *
     * Tickets
     *      Seats
     *
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDto> tickets) {
        this.tickets = tickets;
    }
}
