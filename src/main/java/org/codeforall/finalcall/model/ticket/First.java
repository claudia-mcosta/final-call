package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
public class First extends Ticket {

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.FIRST;
    }

}
