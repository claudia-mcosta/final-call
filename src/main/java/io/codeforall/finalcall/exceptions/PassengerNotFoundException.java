package io.codeforall.finalcall.exceptions;

import io.codeforall.finalcall.error.ErrorMessage;

public class PassengerNotFoundException extends FinalCallException {

    public PassengerNotFoundException() {
        super(ErrorMessage.PASSENGER_NOT_FOUND);
    }
}
