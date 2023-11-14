package io.codeforall.finalcall.exceptions;

import io.codeforall.finalcall.error.ErrorMessage;

public class AssociationExistsException extends FinalCallException {

    public AssociationExistsException() {
        super(ErrorMessage.ASSOCIATION_EXISTS);
    }
}