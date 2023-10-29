package org.codeforall.finalcall;

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
