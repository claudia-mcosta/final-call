package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ECONOMY")
public class Economy extends Ticket {

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.ECONOMY;
    }

}
