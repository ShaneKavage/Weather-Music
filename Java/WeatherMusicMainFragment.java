package com.kavage.weathermusic;
/**
Shane Kavage
Weather Music -WeatherMusicMainFragment.java
This is the main engine of the code. It cuts up the JSONObject information into readable bits
then loads those bits into textviews and displays the desired information.
 **/
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
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
import java.util.Locale;
/**
 * A placeholder fragment containing a simple view.
 **/
public class WeatherMusicMainFragment extends Fragment
{

    Typeface weatherFont;   //To display the weather icon
    Typeface TextViewFont;
    IconHandler ih = new IconHandler();
    CityPreference prefs;

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
        cityField = rootView.findViewById(R.id.city_field);
        updatedField = rootView.findViewById(R.id.updated_field);
        detailsField = rootView.findViewById(R.id.details_field);
        currentTemperatureField = rootView.findViewById(R.id.current_temperature_field);
        weatherIcon = rootView.findViewById(R.id.weather_icon);
        prefs = new CityPreference(getActivity());

        //eventually encapsulate into method so user can pass it different fonts in settings or someting.
        cityField.setTypeface(TextViewFont);
        updatedField.setTypeface(TextViewFont);
        detailsField.setTypeface(TextViewFont);
        currentTemperatureField.setTypeface(TextViewFont);
        weatherIcon.setTypeface(weatherFont);

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Begins the repeating task every minute from when it starts
        startRepeatingTask();

        TextViewFont = Typeface.createFromAsset(getActivity().getAssets(),"fonts/caviar.ttf");
        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");

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
                    details.getString("description").toUpperCase(Locale.US));

            currentTemperatureField.setText(
                    String.format("%.2f", main.getDouble("temp"))+ " F°");


            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
            String time =  mdformat.format(calendar.getTime());

            updatedField.setText("Last update: " + time);

            int stormCode = details.getInt("id");


            weatherIcon.setText(( ih.updateIcon(getActivity(), stormCode,
                    json.getJSONObject("sys").getLong("sunrise") * 1000,
                    json.getJSONObject("sys").getLong("sunset") * 1000) ));

            updateBackground(stormCode);

        }catch(Exception e)
        {
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }

    public void changeCity(String city){
        updateWeatherData(city);
    }

    public void updateInfo(View view) { updateWeatherData(new CityPreference(getActivity()).getCity());}

    public void startRepeatingTask() { mHandlerTask.run();}

    public void updateBackground(int code)
    {
        BackgroundHandler bh = new BackgroundHandler();
        bh.setBackground(getActivity(), code);
    }
    public void updateMusic(int code)
    {
        MusicHandler mh = new MusicHandler();

    }


}
