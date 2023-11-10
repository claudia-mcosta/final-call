package org.codeforall.finalcall.exceptions;

import org.codeforall.finalcall.error.ErrorMessage;

public class AssociationExistsException extends FinalCallException {

    public AssociationExistsException() {
        super(ErrorMessage.ASSOCIATION_EXISTS);
    }
}