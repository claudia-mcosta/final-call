package io.codeforall.finalcall.command;

import io.codeforall.finalcall.persistence.model.Airport;

import java.util.Date;

public class FlightDto {

    private String code;
    private String carrier;
    // TODO: Check if DTO inside DTO is ok or if it's best to add the airport fields to this DTO
    private String departureAirportCode;
    private String destinationAirportCode;
    private Date departureTime;
    private String duration;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "code='" + code + '\'' +
                ", carrier='" + carrier + '\'' +
                ", departure=" + departureAirportCode +
                ", destination=" + destinationAirportCode +
                ", departureTime=" + departureTime +
                ", duration='" + duration + '\'' +
                '}';
    }
}
