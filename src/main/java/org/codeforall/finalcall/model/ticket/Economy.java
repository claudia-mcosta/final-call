package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
public class Economy extends Ticket {

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.ECONOMY;
    }

}
