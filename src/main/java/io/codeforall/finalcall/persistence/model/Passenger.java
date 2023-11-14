package io.codeforall.finalcall.persistence.model;

import io.codeforall.finalcall.persistence.model.ticket.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Ticket> tickets = new ArrayList<>();
    // Not sure about this list due to db schema
    // private List<Passenger> travelCompanions;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setPassenger(this);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setPassenger(null);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "nationalId='" + nationalId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", tickets=" + tickets.size() +
                '}';
    }
}