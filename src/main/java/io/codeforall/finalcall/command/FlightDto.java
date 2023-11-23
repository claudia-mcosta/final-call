package io.codeforall.finalcall.command;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class FlightDto {

    @NotNull(message = "Flight code is mandatory")
    @Size(min = 6, max = 6, message = "Flight code should have 6 characters.")
    private String code;
    @NotNull(message = "Carrier is mandatory.")
    @NotBlank(message = "Carrier is mandatory.")
    private String carrier;
    @NotNull(message = "Origin airport IATA is mandatory.")
    @Size(min = 3, max = 3, message = "Origin airport IATA should have 3 characters.")
    private String originAirportCode;
    @NotNull(message = "Destination airport IATA is mandatory.")
    @Size(min = 3, max = 3, message = "Destination airport IATA should have 3 characters.")
    private String destinationAirportCode;
    @NotNull(message = "Departure time is mandatory.")
    @Future(message = "Departure time should be in the future.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
    private Date departureTime;
    @NotNull(message = "Flight duration is mandatory.")
    private int duration;

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

    public String getOriginAirportCode() {
        return originAirportCode;
    }

    public void setOriginAirportCode(String originAirportCode) {
        this.originAirportCode = originAirportCode;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "code='" + code + '\'' +
                ", carrier='" + carrier + '\'' +
                ", origin=" + originAirportCode +
                ", destination=" + destinationAirportCode +
                ", departureTime=" + departureTime +
                ", duration='" + duration + '\'' +
                '}';
    }
}
