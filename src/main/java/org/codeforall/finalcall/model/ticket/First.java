package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FIRST")
public class First extends Ticket {

    public static final int FREE_CABIN_BAGS = 2;
    public static final int FREE_CHECKED_BAGS = 2;

    public First() {
        super();
        addCabinBag(FREE_CABIN_BAGS);
        addCheckedBag(FREE_CHECKED_BAGS);
    }
    @Override
    public CabinClass getCabinClass() {
        return CabinClass.FIRST;
    }

}
