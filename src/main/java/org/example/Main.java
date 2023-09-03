package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
        URL url = null;
        HttpURLConnection connection = null;
        int responseCode = 0;
        String urlString = "https://api.nationalize.io/?name=nathaniel";


        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("problem in URL");
        }

        //connection

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("connection problem");
        }

        //extract information from the connection object:

        if(responseCode == 200)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while((readLine = in.readLine())!= null)
            {
                apiData.append(readLine);
            }

            //
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println(apiData.toString());
        }
        else
            System.out.println("API call could not be made!!!");

    }
}