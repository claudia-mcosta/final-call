package io.codeforall.finalcall.exceptions;

import io.codeforall.finalcall.error.ErrorMessage;

public class SeatUnavailableException extends FinalCallException {

    public SeatUnavailableException() {
        super(ErrorMessage.SEAT_UNAVAILABLE);
    }
}
