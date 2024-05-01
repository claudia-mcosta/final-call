package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.TicketDto;
import io.codeforall.finalcall.persistence.model.ticket.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketToTicketDto {

    public List<TicketDto> convert(List<Ticket> tickets) {

        return tickets.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public TicketDto convert(Ticket ticket) {

        TicketDto ticketDto = new TicketDto();

        ticketDto.setCabinClass(ticket.getCabinClass());
        ticketDto.setPrice(ticket.getPrice());
        ticketDto.setSeat(ticket.getSeat());
        ticketDto.setCabinBags(ticket.getCabinBags());
        ticketDto.setCheckedBags(ticket.getCheckedBags());

        return ticketDto;
    }
}
