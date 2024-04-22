package io.codeforall.finalcall.exceptions;

import io.codeforall.finalcall.error.ErrorMessage;

public class TicketNotFoundException extends FinalCallException {

    public TicketNotFoundException() {
        super(ErrorMessage.TICKET_NOT_FOUND);
    }
}
