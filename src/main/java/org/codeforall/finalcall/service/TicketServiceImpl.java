package org.codeforall.finalcall.service;

import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;
import org.codeforall.finalcall.persistence.dao.FlightDao;
import org.codeforall.finalcall.persistence.dao.PassengerDao;
import org.codeforall.finalcall.persistence.dao.TicketDao;

public class TicketServiceImpl implements TicketService {
    private TicketDao ticketDao;

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket get(TicketId ticketId) {
        return ticketDao.findById(ticketId);
    }

}
