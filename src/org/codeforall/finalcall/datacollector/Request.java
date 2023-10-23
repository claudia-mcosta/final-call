package org.codeforall.finalcall.datacollector;

public class Request {

    private String httpVerb;
    private String path;
    private String header;
    private Query queryObject;

    public void buildHeader(){
        String agentType = "AGENT_TYPE_AIRLINE";
    }

    public static void main(String[] args) {
        Query query = new Query();
        query.setCultureData("en", "PT", "EUR");
        query.addQueryLeg("LIS", "LDN");
        System.out.println(query);
    }
}