package org.codeforall.finalcall.datacollector;

import java.time.LocalDateTime;
import java.util.Arrays;

// Check "query" object in Skyscanner API documentation: https://developers.skyscanner.net/api/flights-live-pricing#tag/FlightsService/operation/FlightsService_CreateSearch
public class Query {

    private String market;
    private String locale;
    private String currency;
    private QueryLeg[] queryLegs;
    private CabinClass cabinClass;
    private int adults;
    private int[] childrenAges;
    private String[] includedCarriersIds;
    private String[] excludedCarriersIds;
    private String[] includedAgentsIds;
    private String[] excludedAgentsIds;
    private boolean includeSustainabilityData;
    private boolean nearbyAirports;

    public Query(){
        this.market = "";
        this.locale = "";
        this.currency = "";
        this.queryLegs = new QueryLeg[0];
        this.cabinClass = CabinClass.CABIN_CLASS_UNSPECIFIED;
        this.adults = 1;
        this.childrenAges = new int[]{0};
        this.includedCarriersIds = new String[0];
        this.excludedCarriersIds = new String[0];
        this.includedAgentsIds = new String[0];
        this.excludedAgentsIds = new String[0];
        this.includeSustainabilityData = false;
        this.nearbyAirports = false;

    }

    public void setCultureData(String market, String locale, String currency) {
        this.market = market;
        this.locale = locale;
        this.currency = currency;
    }

    public void addQueryLeg(String originIata, String destinationIata) {

        int index = this.queryLegs.length;

        this.queryLegs = new QueryLeg[index + 1];
        this.queryLegs[index] = new QueryLeg(originIata, destinationIata);
    }

    @Override
    public String toString() {
        return "{\"query\":{" +
                "\"market\":\"" + market + '"' +
                ", \"locale\":\"" + locale + '"' +
                ", \"currency\":\"" + currency + '"' +
                ", \"queryLegs\":" + Arrays.toString(queryLegs) +
                ", \"cabinClass\":\"" + cabinClass + '"' +
                ", \"adults\":" + adults +
                ", \"childrenAges\":" + Arrays.toString(childrenAges) +
                ", \"includedCarriersIds\":" + Arrays.toString(includedCarriersIds) +
                ", \"excludedCarriersIds\":" + Arrays.toString(excludedCarriersIds) +
                ", \"includedAgentsIds\":" + Arrays.toString(includedAgentsIds) +
                ", \"excludedAgentsIds\":" + Arrays.toString(excludedAgentsIds) +
                ", \"includeSustainabilityData\":" + includeSustainabilityData +
                ", \"nearbyAirports\":" + nearbyAirports +
                '}' +
                '}';
    }

    private class QueryLeg {
        private String originIata;
        private String originEntityID;
        private String destinationIata;
        private String destinationEntityID;
        private int year;
        private int month;
        private int day;

        public QueryLeg(String originIata, String destinationIata) {

            LocalDateTime date = LocalDateTime.now();

            this.originIata = originIata;
            this.originEntityID = "";
            this.destinationIata = destinationIata;
            this.destinationEntityID = "";
            this.year = date.getYear();
            this.month = date.getMonthValue();
            this.day = date.getDayOfMonth();
        }

        @Override
        public String toString() {
            return '{' +
                    "\"originPlaceID\":{" +
                    "\"originIata\":\"" + originIata + '"' +
                    ", \"originEntityID\":\"" + originEntityID + '"' +
                    '}' +
                    ", \"destinationPlaceID\":{" +
                    "\"destinationIata\":\"" + destinationIata + '"' +
                    ", \"destinationEntityID\":\"" + destinationEntityID + '"' +
                    '}' +
                    ", \"date\":{" +
                    "\"year\":" + year +
                    ", \"month\":" + month +
                    ", \"day\":" + day +
                    '}' +
                    '}';
        }
    }

    private enum CabinClass {
        CABIN_CLASS_UNSPECIFIED,
        CABIN_CLASS_ECONOMY,
        CABIN_CLASS_PREMIUM_ECONOMY,
        CABIN_CLASS_BUSINESS,
        CABIN_CLASS_FIRST
    }
}