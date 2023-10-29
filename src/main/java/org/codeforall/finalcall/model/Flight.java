package org.codeforall.finalcall.model;

import javax.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    private String code;
    private String carrier;
    @ManyToOne
    @JoinColumn(name = "departure_airport_code")
    private Airport departure;
    @ManyToOne
    @JoinColumn(name = "destination_airport_code")
    private Airport destination;
    @Column(name = "departure_time")
    private String departureTime;
    private String duration;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}