package com.kavage.weathermusic;
/**
Shane Kavage
Weather Music - CityPreference.java
The purpose is to save the current city so the user doesn't have to
continually re-enter their city location.
 **/
import android.app.Activity;
import android.content.SharedPreferences;

public class CityPreference {

    SharedPreferences prefs;

    //Grabs the prefs to be read and altered
    public CityPreference(Activity activity)
    {
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Fond du Lac as the default city
    String getCity(){
        return prefs.getString("city", "Fond du Lac, US");
    }

    //Saves the city in the prefs so it can be automatically loaded when the app opens
    void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }

}
