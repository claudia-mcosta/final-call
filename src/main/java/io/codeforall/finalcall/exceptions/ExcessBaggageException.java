package io.codeforall.finalcall.exceptions;

import io.codeforall.finalcall.error.ErrorMessage;

public class ExcessBaggageException extends FinalCallException {

    public ExcessBaggageException() {
        super(ErrorMessage.EXCESS_BAGGAGE);
    }
}