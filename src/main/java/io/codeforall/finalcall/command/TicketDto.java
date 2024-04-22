package io.codeforall.finalcall.command;

import io.codeforall.finalcall.persistence.model.ticket.CabinClass;

public class TicketDto {

    private CabinClass cabinClass;
    private double price;
    private String seat;
    private int cabinBags;
    private int checkedBags;

    public CabinClass getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(CabinClass cabinClass) {
        this.cabinClass = cabinClass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getCabinBags() {
        return cabinBags;
    }

    public void setCabinBags(int cabinBags) {
        this.cabinBags = cabinBags;
    }

    public int getCheckedBags() {
        return checkedBags;
    }

    public void setCheckedBags(int checkedBags) {
        this.checkedBags = checkedBags;
    }
}
