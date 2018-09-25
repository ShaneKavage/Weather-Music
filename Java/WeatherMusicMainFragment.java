package com.kavage.weathermusic;
/**
Shane Kavage
Weather Music -WeatherMusicMainFragment.java
This is the main engine of the code. It cuts up the JSONObject information into readable bits
then loads those bits into textviews and displays the desired information.
 **/
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

/**
 * A placeholder fragment containing a simple view.
 **/
public class WeatherMusicMainFragment extends Fragment
{

    TextClock clock;    //Clock to display the current time
    Typeface weatherFont;   //To display the weather icon
    Timer timeHandler; //To tick every minute, and hour

    private  final static int INTERVAL = 1000 * 60; //Currently used to mean 1 minute
    Handler mHandler = new Handler();

    //Runs a task every minute from when it starts to update the views info.
    Runnable mHandlerTask = new Runnable()
    {
        @Override
        public void run()
        {
            updateInfo(getView());
            mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    //Views for information
    TextView cityField;
    TextView updatedField;
    TextView detailsField;
    TextView currentTemperatureField;
    TextView weatherIcon;

    Handler handler;

    public WeatherMusicMainFragment()
    {
        handler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        //Sets the views in the xml to these views, allowing for the values to be changed
        View rootView = inflater.inflate(R.layout.fragment_weather_music_main, container, false);
        clock = rootView.findViewById(R.id.textClock);
        cityField = rootView.findViewById(R.id.city_field);
        updatedField = rootView.findViewById(R.id.updated_field);
        detailsField = rootView.findViewById(R.id.details_field);
        currentTemperatureField = rootView.findViewById(R.id.current_temperature_field);
        weatherIcon = rootView.findViewById(R.id.weather_icon);

        weatherIcon.setTypeface(weatherFont);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "Assets/fonts/weather.ttf");
        //Begins the repeating task every minute from when it starts
        startRepeatingTask();

    }

    /**
     * Purpose: Re-fetches the JSONObject with the city from the user input and sends it to update the textviews.
     * Input: City
     * Output: nothing/renders the textviews with the updated weather
     */
    private void updateWeatherData(final String city)
    {
        new Thread(){
            public void run(){
                final JSONObject json = RemoteFetch.getJSON(getActivity(), city);
                if(json == null){
                    handler.post(new Runnable(){
                        public void run(){
                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.place_not_found),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    handler.post(new Runnable(){
                        public void run(){
                            renderWeather(json);
                        }
                    });
                }
            }
        }.start();
    }

    /**
     * Purpose:Parses the JSONObject to display desired information.
     * Input:JSONObject
     * Output:nothing/updated textviews
     */
    private void renderWeather(JSONObject json){
        try {
            cityField.setText(json.getString("name") +
                    ", " +
                    json.getJSONObject("sys").getString("country"));

            //Searches different arrays or object parameters for values.
            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
            JSONObject main = json.getJSONObject("main");

            detailsField.setText(
                    details.getString("description").toUpperCase(Locale.US) +
                            "\n" + "Humidity: " + main.getString("humidity") + "%" +
                            "\n" + "Pressure: " + main.getString("pressure") + " hPa");

            currentTemperatureField.setText(
                    String.format("%.2f", main.getDouble("temp"))+ " F°");


            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
            String time =  mdformat.format(calendar.getTime());

            updatedField.setText("Last update: " + time);

            setWeatherIcon(details.getInt("id"),
                    json.getJSONObject("sys").getLong("sunrise") * 1000,
                    json.getJSONObject("sys").getLong("sunset") * 1000);

        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }

    private void setWeatherIcon(int actualId, long sunrise, long sunset){
        int id = actualId / 100;
        String icon = "";
        if(actualId == 800){
            long currentTime = new Date().getTime();
            if(currentTime>=sunrise && currentTime<sunset) {
                icon = getActivity().getString(R.string.weather_sunny);
            } else {
                icon = getActivity().getString(R.string.weather_clear_night);
            }
        } else {
            switch(id) {
                case 2 : icon = getActivity().getString(R.string.weather_thunder);
                    break;
                case 3 : icon = getActivity().getString(R.string.weather_drizzle);
                    break;
                case 7 : icon = getActivity().getString(R.string.weather_foggy);
                    break;
                case 8 : icon = getActivity().getString(R.string.weather_cloudy);
                    break;
                case 6 : icon = getActivity().getString(R.string.weather_snowy);
                    break;
                case 5 : icon = getActivity().getString(R.string.weather_rainy);
                    break;
            }
        }
        weatherIcon.setText(icon);
    }

    public void changeCity(String city){
        updateWeatherData(city);
    }

    public void updateInfo(View view) { updateWeatherData(new CityPreference(getActivity()).getCity());}

    public void startRepeatingTask() { mHandlerTask.run();}
    public void stopRepeatingTask() { mHandler.removeCallbacks(mHandlerTask);}

}
