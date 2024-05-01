package io.codeforall.finalcall.factory;

import io.codeforall.finalcall.persistence.model.ticket.*;
import io.codeforall.finalcall.error.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
public class TicketFactory {

    public Ticket createTicket(CabinClass cabinClass) {

        Ticket ticket;

        switch(cabinClass) {
            case ECONOMY:
                ticket = new EconomyClass();
                break;
            case PREMIUM_ECONOMY:
                ticket = new PremiumEconomyClass();
                break;
            case BUSINESS:
                ticket = new BusinessClass();
                break;
            case FIRST:
                ticket = new FirstClass();
                break;
            default:
                throw new IllegalArgumentException(ErrorMessage.INVALID_CABIN_CLASS);
        }

        return ticket;
    }
}
