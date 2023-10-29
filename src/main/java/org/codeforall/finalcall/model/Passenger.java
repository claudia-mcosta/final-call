package org.codeforall.finalcall.model;

import org.codeforall.finalcall.model.ticket.Ticket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String dob;
    private String email;
    private String phone;
    @OneToMany(
        cascade = {CascadeType.ALL},
        orphanRemoval = true,
        mappedBy = "passenger",
        fetch = FetchType.EAGER
    )
    private List<Ticket> tickets;
    // private List<Passenger> travelCompanions; // Not sure yet due to db schema

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
