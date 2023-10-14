package org.codeforall.luckytrip.model;

public class Airport {

    private String name;
    private String city;
    private String country;
    private Continent continent;

    private enum Continent {

        AFRICA,
        ASIA,
        EUROPE,
        OCEANIA,
        NORTH_AMERICA,
        SOUTH_AMERICA;

    }
}
