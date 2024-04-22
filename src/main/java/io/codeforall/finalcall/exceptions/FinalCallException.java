package io.codeforall.finalcall.exceptions;

/**
 * A generic java bank exception to be used as base for concrete types of exceptions
 *
 * @see Exception
 */
public class FinalCallException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public FinalCallException(String message) {
        super(message);
    }
}
