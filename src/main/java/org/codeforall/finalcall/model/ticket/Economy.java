package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ECONOMY")
public class Economy extends Ticket {

    public static final int SEATS_PER_ROW = 6;
    public static final int FREE_CABIN_BAGS = 0;
    public static final int FREE_CHECKED_BAGS = 0;

    public Economy() {
        super();
        addCabinBag(FREE_CABIN_BAGS);
        addCheckedBag(FREE_CHECKED_BAGS);    }

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.ECONOMY;
    }
}
