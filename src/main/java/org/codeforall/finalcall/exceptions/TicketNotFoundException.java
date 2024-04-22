package org.codeforall.finalcall.exceptions;

import org.codeforall.finalcall.error.ErrorMessage;

public class TicketNotFoundException extends FinalCallException {

    public TicketNotFoundException() {
        super(ErrorMessage.TICKET_NOT_FOUND);
    }
}
