package org.codeforall.finalcall.model;

import javax.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    private String code;
    private String carrier;
    @ManyToOne
    private Airport departure;
    @ManyToOne
    private Airport destination;
    private String departureTime;
    private String duration;

}