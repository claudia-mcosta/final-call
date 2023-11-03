package org.codeforall.finalcall.exceptions;

import org.codeforall.finalcall.error.ErrorMessage;

public class PassengerNotFoundException extends FinalCallException {

    public PassengerNotFoundException() {
        super(ErrorMessage.PASSENGER_NOT_FOUND);
    }
}
