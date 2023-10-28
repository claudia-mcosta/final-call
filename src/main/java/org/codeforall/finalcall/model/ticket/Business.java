package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
public class Business extends Ticket {

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.BUSINESS;
    }

}
