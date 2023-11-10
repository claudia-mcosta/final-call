package org.codeforall.finalcall.exceptions;

import org.codeforall.finalcall.error.ErrorMessage;

public class FlightNotFoundException extends FinalCallException {

    public FlightNotFoundException() {
        super(ErrorMessage.FLIGHT_NOT_FOUND);
    }
}