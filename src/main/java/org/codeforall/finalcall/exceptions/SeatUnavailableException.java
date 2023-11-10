package org.codeforall.finalcall.exceptions;

import org.codeforall.finalcall.error.ErrorMessage;

public class SeatUnavailableException extends FinalCallException {

    public SeatUnavailableException() {
        super(ErrorMessage.SEAT_UNAVAILABLE);
    }
}
