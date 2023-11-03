package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;

public interface TicketService {

    Ticket get(TicketId ticketId);

}
