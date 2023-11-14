package io.codeforall.finalcall.exceptions;

import io.codeforall.finalcall.error.ErrorMessage;

public class FlightNotFoundException extends FinalCallException {

    public FlightNotFoundException() {
        super(ErrorMessage.FLIGHT_NOT_FOUND);
    }
}