package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FIRST")
public class First extends Ticket {

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.FIRST;
    }

}
