package io.codeforall.finalcall.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    private String code;
    private String carrier;
    @ManyToOne
    @JoinColumn(name = "origin_airport_code")
    private Airport origin;
    @ManyToOne
    @JoinColumn(name = "destination_airport_code")
    private Airport destination;
    @Column(name = "departure_time")
    private Date departureTime;
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

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
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
        return "Flight{" +
                "code='" + code + '\'' +
                ", carrier='" + carrier + '\'' +
                ", origin=" + origin.getCode() +
                ", destination=" + destination.getCode() +
                ", departureTime='" + departureTime + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}