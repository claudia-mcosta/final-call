package org.codeforall.finalcall.model;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    private String nationalId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String phone;
    // private List<Passenger> travelCompanions; // Not sure yet due to db schema

}
