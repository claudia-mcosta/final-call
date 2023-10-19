package org.codeforall.finalcall.datacollector;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FlightDataCollector {

    private String baseUrl = "https://partners.api.skyscanner.net/apiservices/v3/geo/";
    private String publicApiKey = "sh428739766321522266746152871799";
    private String destinationFilePath = "src/main/resources/db/real-data.sql";

    public FlightDataCollector() {
        connect("POST", "");
        //read();
        //writeToFile();
    }

    public void connect(String httpVerb, String path) {

        String urlString = baseUrl + path;
        InputStream in = null;

        try {

            URL url = new URL(baseUrl + path);
            in = new BufferedInputStream(url.openStream());
            InputStreamReader reader = new InputStreamReader(in);

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (MalformedURLException e) {

            System.out.println("Invalid URL: " + urlString);

        } catch (IOException e) {

            System.out.println(e.getMessage());

        } finally {

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
    }

}
