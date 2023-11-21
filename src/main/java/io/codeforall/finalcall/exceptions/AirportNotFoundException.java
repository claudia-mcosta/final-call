package io.codeforall.finalcall.exceptions;

import io.codeforall.finalcall.error.ErrorMessage;

public class AirportNotFoundException extends FinalCallException {

    public AirportNotFoundException() {
        super(ErrorMessage.AIRPORT_NOT_FOUND);
    }
}
