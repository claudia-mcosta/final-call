package org.codeforall.finalcall;

import org.codeforall.finalcall.model.Flight;
import org.codeforall.finalcall.model.Passenger;
import org.codeforall.finalcall.model.ticket.Ticket;
import org.codeforall.finalcall.model.ticket.TicketId;
import org.codeforall.finalcall.persistence.JpaBootstrap;

import javax.persistence.EntityManagerFactory;

public class App {

    public static void main(String[] args) {

        JpaBootstrap jpa = new JpaBootstrap();
        EntityManagerFactory emf = jpa.start();

        App app = new App();

        jpa.stop();

    }
}
