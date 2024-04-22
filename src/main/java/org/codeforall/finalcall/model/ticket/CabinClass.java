package org.codeforall.finalcall.model.ticket;

public enum CabinClass {

    ECONOMY(6),
    PREMIUM_ECONOMY(6),
    BUSINESS(4),
    FIRST(4);

    private final int seatsPerRow;

    CabinClass(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }
}