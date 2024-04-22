package org.codeforall.finalcall.exceptions;

import org.codeforall.finalcall.error.ErrorMessage;

public class ExcessBaggageException extends FinalCallException {

    public ExcessBaggageException() {
        super(ErrorMessage.EXCESS_BAGGAGE);
    }
}