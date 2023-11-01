package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("BUSINESS")
public class Business extends Ticket {

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.BUSINESS;
    }

}
