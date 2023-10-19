package org.codeforall.finalcall.datacollector;

// Check "query" object in Skyscanner API documentation: https://developers.skyscanner.net/api/flights-live-pricing#tag/FlightsService/operation/FlightsService_CreateSearch
public class Query {

    private String market;
    private String locale;
    private String currency;
    private QueryLeg[] queryLegs;
    private CabinClass cabinClass; // API documentation says this is a String
    private int adults;
    private int[] childrenAges;
    private String[] includedCarriersIds;
    private String[] excludedCarriersIds;
    private String[] includedAgentsIds;
    private String[] excludedAgentsIds;
    private boolean includeSustainabilityData;
    private boolean nearbyAirports;

    private class QueryLeg {
        private String originIata;
        private String originEntityID;
        private int year;
        private int month;
        private int day;
    }

    private enum CabinClass {
        CABIN_CLASS_UNSPECIFIED,
        CABIN_CLASS_ECONOMY,
        CABIN_CLASS_PREMIUM_ECONOMY,
        CABIN_CLASS_BUSINESS,
        CABIN_CLASS_FIRST
    }

}