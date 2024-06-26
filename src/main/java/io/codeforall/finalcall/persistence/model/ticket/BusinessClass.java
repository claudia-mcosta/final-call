package io.codeforall.finalcall.persistence.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("BUSINESS")
public class BusinessClass extends Ticket {

    public static final int FREE_CABIN_BAGS = 1;
    public static final int FREE_CHECKED_BAGS = 1;

    public BusinessClass() {
        super();
        addCabinBag(FREE_CABIN_BAGS);
        addCheckedBag(FREE_CHECKED_BAGS);
    }

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.BUSINESS;
    }

}
