package com.kavage.weathermusic;
/**
Shane Kavage
Weather Music -WeatherMusicMainFragment.java
This is the main engine of the code. It cuts up the JSONObject information into readable bits
then loads those bits into textviews and displays the desired information.
 **/
import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kavage.weathermusic.BackgroundHandler.BackgroundCodeManager;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/**
 * A placeholder fragment containing a simple view.
 **/
public class WeatherMusicMainFragment extends Fragment
{
    //Fonts for text, and weather icons
    Typeface weatherFont, TextViewFont;
    int stormcode;

    //Views for information
    TextView cityField, updatedField, detailsField, currentTemperatureField, weatherIcon;

    //Task to update every 1
    private  final static int INTERVAL = 1000 * 60; //Currently used to mean 1 minute
    Handler mHandler = new Handler();
    Runnable mHandlerTask = new Runnable()
    {
        @Override
        public void run()
        {
            updateWeatherData(new CityPreference(getActivity()).getCity());
            mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    Handler handler;
    public WeatherMusicMainFragment()
    {
        handler = new Handler();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        //Sets the views in the xml to these views, allowing for the values to be changed
        View rootView = inflater.inflate(R.layout.fragment_weather_music_main, container, false);
        cityField = rootView.findViewById(R.id.city_field);
        updatedField = rootView.findViewById(R.id.updated_field);
        detailsField = rootView.findViewById(R.id.details_field);
        currentTemperatureField = rootView.findViewById(R.id.current_temperature_field);
        weatherIcon = rootView.findViewById(R.id.weather_icon);

        //Sets the fonts for each view and the icons for the weather icon
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

        TextViewFont = Typeface.createFromAsset(getActivity().getAssets(),"fonts/caviar.ttf");
        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");

        startRepeatingTask();
    }

    /**
     * Purpose: Re-fetches the JSONObject with the city from the user input and sends it to update the textviews.
     * Input: City
     * Output: nothing/renders the textviews with the updated weather
     */
    protected void updateWeatherData(final String city)
    {
        new Thread(){
            public void run(){
                final JSONObject json = RemoteFetch.getJSON(getActivity(), city);
                if(json == null){
                    handler.post(new Runnable(){
                        public void run(){
                            Toast.makeText(getActivity(),
                                    getString(R.string.place_not_found),
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
            //Searches different arrays or object parameters for values.
            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
            JSONObject main = json.getJSONObject("main");
            JSONObject sys = json.getJSONObject("sys");

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
            String time =  mdformat.format(calendar.getTime());

            int stormCode = details.getInt("id");
            stormcode = stormCode;

            IconHandler ih = new IconHandler(getActivity());

            cityField.setText(json.getString("name") + ", " + sys.getString("country"));
            detailsField.setText(details.getString("description").toUpperCase(Locale.US));
            currentTemperatureField.setText(String.format("%.2f", main.getDouble("temp"))+ " F°");
            updatedField.setText("Last update: " + time);
            weatherIcon.setText(( ih.updateIcon(getActivity(), stormCode)));

            updateBackground(stormCode);

        }catch(Exception e)
        {
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }

    public void startRepeatingTask() { mHandlerTask.run();}

    public void updateBackground(int code)
    {
        BackgroundCodeManager BCM = new BackgroundCodeManager();
        BCM.chooseHandler(code, getActivity());
    }
}
