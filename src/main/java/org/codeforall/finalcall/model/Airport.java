package org.codeforall.finalcall.model;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    private String code; // IATA code
    private String name;
    private String city;
    private String country;
    private double latitude;
    private double longitude;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
