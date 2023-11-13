package org.codeforall.finalcall.persistence.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FIRST")
public class FirstClass extends Ticket {

    public static final int FREE_CABIN_BAGS = 2;
    public static final int FREE_CHECKED_BAGS = 2;

    public FirstClass() {
        super();
        addCabinBag(FREE_CABIN_BAGS);
        addCheckedBag(FREE_CHECKED_BAGS);
    }

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.FIRST;
    }

}
