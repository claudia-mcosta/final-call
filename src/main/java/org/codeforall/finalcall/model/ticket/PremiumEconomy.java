package org.codeforall.finalcall.model.ticket;

import javax.persistence.*;

@Entity
public class PremiumEconomy extends Ticket {

    @Override
    public CabinClass getCabinClass() {
        return CabinClass.PREMIUM_ECONOMY;
    }

}
