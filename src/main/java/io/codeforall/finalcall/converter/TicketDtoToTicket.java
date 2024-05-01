package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.TicketDto;
import io.codeforall.finalcall.factory.TicketFactory;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketDtoToTicket {

    private TicketFactory ticketFactory;

    @Autowired
    public void setTicketFactory(TicketFactory ticketFactory) {
        this.ticketFactory = ticketFactory;
    }

    public List<Ticket> convert(List<TicketDto> ticketDtos) {

        return ticketDtos.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public Ticket convert(TicketDto ticketDto) {

        Ticket ticket = ticketFactory.createTicket(ticketDto.getCabinClass());

        ticket.setPrice(ticketDto.getPrice());
        ticket.checkIn(ticketDto.getSeat());
        ticket.addCabinBag(ticketDto.getCabinBags() - ticket.getCabinBags());
        ticket.addCheckedBag(ticketDto.getCheckedBags() - ticket.getCheckedBags());

        return ticket;
    }
}
