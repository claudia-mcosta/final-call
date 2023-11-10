package org.codeforall.finalcall;

import org.codeforall.finalcall.model.ticket.CabinClass;

import java.util.List;

public class SeatRandomizer {

    public static final int SEATS_TOTAL = 360;
    public static final double ECONOMY_SEATS_PERCENTAGE = 72.2;

    private static int getRows(CabinClass cabinClass) {

        int seats = (int) Math.floor(SEATS_TOTAL * ECONOMY_SEATS_PERCENTAGE / 100);

        if (cabinClass.compareTo(CabinClass.BUSINESS) > -1)
            seats = (SEATS_TOTAL - seats) / 2;

        return seats / cabinClass.getSeatsPerRow();
    }

    public static String getSeat(CabinClass cabinClass, List<String> occupiedSeats) {

        // Bernard suggested to comb through the occupied seats and assign the first one free in that class. Is that possible?

        // Calculate row number
        int seatRow = (int) (Math.random() * getRows(cabinClass));

        if (cabinClass.compareTo(CabinClass.FIRST) < 0)
            seatRow += getRows(CabinClass.FIRST);

        if (cabinClass.compareTo(CabinClass.BUSINESS) < 0)
            seatRow += getRows(CabinClass.BUSINESS);


        // This is an "A"
        char seatLetter= 65;
        // Calculate seat letter
        seatLetter += (char) (Math.random() * cabinClass.getSeatsPerRow());


        // Concatenate row number and seat letter
        String seat = String.valueOf(seatRow) + seatLetter;

        // Check if seat is already taken
        for(String s:occupiedSeats)
            if(seat.equals(s))
                seat = getSeat(cabinClass, occupiedSeats);

        return seat;
    }
}