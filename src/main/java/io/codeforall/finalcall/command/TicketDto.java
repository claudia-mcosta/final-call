package io.codeforall.finalcall.command;

import io.codeforall.finalcall.persistence.model.ticket.CabinClass;

public class TicketDto {

    private CabinClass cabinClass;
    private double price;
    private String seat;
    private int cabinBags;
    private int checkedBags;
    private FlightDto flight;
    private PassengerDto passenger;

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

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flight) {
        this.flight = flight;
    }

    public PassengerDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDto passenger) {
        this.passenger = passenger;
    }
}
