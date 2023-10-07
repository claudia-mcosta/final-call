package org.codeforall.luckytrip.model;

public class Flight {

    private String id;
    private String carrier;
    private String departure;
    private String destination;
    private String date;
    private String departureTime;
    private String duration;
    private int seatCapacity;

    public int getSeatCapacity() {
        return seatCapacity;
    }
}
