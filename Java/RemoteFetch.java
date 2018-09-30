package com.kavage.weathermusic;
/**
Shane Kavage
Weather Music - RemoteFetch.java
The purpose is to send the api query and receive the JSONObject in return
or return a null if they cannot find the location/encounter an error
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;

public class RemoteFetch
{
    //The Url call with %s in place of the query
    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial";

    /**
    Purpose: To ask for the locations current weather data as a JSONObject, or return null if there's a problem.
    Input: context - usual android studio input, city - city name user has just input.
    Output: JSONObject with desired information, or null.
     **/
    public static JSONObject getJSON(Context context, String city)
    {
        //Attempts to append the url with the query and checks if that location has data.
        try {
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();

            //API key from my account I set up.
            connection.addRequestProperty("x-api-key",
                    context.getString(R.string.open_weather_maps_app_id));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            //Fills the buffer with data from the query call.
            StringBuilder json = new StringBuilder(1024);
            String tmp;
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            //Returns a new JSONObject fill with the stringbuffer's contents.
            JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not successful
            if(data.getInt("cod") != 200){
                return null;
            }

            return data;
        }catch(Exception e){
            return null;
        }
    }
}
