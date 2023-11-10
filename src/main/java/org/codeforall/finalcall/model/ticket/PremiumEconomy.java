package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PREMIUM_ECONOMY")
public class PremiumEconomy extends Ticket {

    public static final int FREE_CABIN_BAGS = 1;
    public static final int FREE_CHECKED_BAGS = 0;

    public PremiumEconomy() {
        super();
        addCabinBag(FREE_CABIN_BAGS);
        addCheckedBag(FREE_CHECKED_BAGS);    }
    @Override
    public CabinClass getCabinClass() {
        return CabinClass.PREMIUM_ECONOMY;
    }
}
