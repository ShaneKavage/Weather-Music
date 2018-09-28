package com.kavage.weathermusic;
/**
 * Shane Kavage
 * WeatherMusic - IconHandler.java
 * Its purpose it to take in the current time of day and id, and output the associated icon.
 */

import android.app.Activity;

import java.util.Date;

public class IconHandler
{

    public String updateIcon(Activity act, int actualId, long sunrise, long sunset) {
        int id = actualId;
        String icon = "";
        long currentTime = new Date().getTime();

        //Daytime icon switch
        if(currentTime>=sunrise && currentTime<sunset)
        {
            switch(id)
            {
                case 1: icon = act.getString(R.string.wi_night_clear); //Not found
                    break;

                //Thunderstorms
                case 200: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with light rain
                    break;
                case 201: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with rain
                    break;
                case 202: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with heavy rain
                    break;
                case 210: icon = act.getString(R.string.wi_day_thunderstorm); //light thunderstorm
                    break;
                case 211: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm
                    break;
                case 212: icon = act.getString(R.string.wi_day_thunderstorm); //heavy thunderstorm
                    break;
                case 221: icon = act.getString(R.string.wi_day_thunderstorm); //ragged thunderstorm
                    break;
                case 230: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with light drizzle
                    break;
                case 231: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with drizzle
                    break;
                case 232: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with heavy drizzle
                    break;

                    //Drizzles
                case 300: icon = act.getString(R.string.wi_day_rain); //light intensity drizzle
                    break;
                case 301: icon = act.getString(R.string.wi_day_rain); //drizzle
                    break;
                case 302: icon = act.getString(R.string.wi_day_rain); //heavy intensity drizzle
                    break;
                case 310: icon = act.getString(R.string.wi_day_rain); //light intensity drizzle rain
                    break;
                case 311: icon = act.getString(R.string.wi_day_rain); //drizzle rain
                    break;
                case 312: icon = act.getString(R.string.wi_day_rain); //heavy intensity drizzle rain
                    break;
                case 313: icon = act.getString(R.string.wi_day_rain); //shower rain and drizzle
                    break;
                case 314: icon = act.getString(R.string.wi_day_rain); //heavy shower rain and drizzle
                    break;
                case 321: icon = act.getString(R.string.wi_day_rain); //shower drizzle
                    break;

                case 4: icon = act.getString(R.string.wi_day_fog);
                    break;

                //Rain
                case 500: icon = act.getString(R.string.wi_day_cloudy); //light rain
                    break;
                case 501: icon = act.getString(R.string.wi_day_cloudy); //moderate rain
                    break;
                case 502: icon = act.getString(R.string.wi_day_cloudy); //heavy intensity rain
                    break;
                case 503: icon = act.getString(R.string.wi_day_cloudy); //very heavy rain
                    break;
                case 504: icon = act.getString(R.string.wi_day_cloudy); //extreme rain
                    break;
                case 511: icon = act.getString(R.string.wi_day_cloudy); //freezing rain
                    break;
                case 520: icon = act.getString(R.string.wi_day_cloudy); //light intensity shower rain
                    break;
                case 521: icon = act.getString(R.string.wi_day_cloudy); //shower rain
                    break;
                case 522: icon = act.getString(R.string.wi_day_cloudy); //heavy intensity shower rain
                    break;
                case 531: icon = act.getString(R.string.wi_day_cloudy); //ragged shower rain
                    break;

                    //Snow
                case 600: icon = act.getString(R.string.wi_day_lightning); //light snow
                    break;
                case 601: icon = act.getString(R.string.wi_day_lightning); //Snow
                    break;
                case 602: icon = act.getString(R.string.wi_day_lightning); //heavy snow
                    break;
                case 611: icon = act.getString(R.string.wi_day_lightning); //sleet
                    break;
                case 612: icon = act.getString(R.string.wi_day_lightning); //shower sleet
                    break;
                case 615: icon = act.getString(R.string.wi_day_lightning); //light rain and snow
                    break;
                case 616: icon = act.getString(R.string.wi_day_lightning); //rain and snow
                    break;
                case 620: icon = act.getString(R.string.wi_day_lightning); //light shower snow
                    break;
                case 621: icon = act.getString(R.string.wi_day_lightning); //shower snow
                    break;
                case 622: icon = act.getString(R.string.wi_day_lightning); //heavy shower snow
                    break;

                //Atmosphere
                case 701: icon = act.getString(R.string.wi_day_haze); //Mist
                    break;
                case 711: icon = act.getString(R.string.wi_day_haze); //smoke
                    break;
                case 721: icon = act.getString(R.string.wi_day_haze); //haze
                    break;
                case 731: icon = act.getString(R.string.wi_day_haze); //sand, dust whirls
                    break;
                case 741: icon = act.getString(R.string.wi_day_haze); //fog
                    break;
                case 751: icon = act.getString(R.string.wi_day_haze); //sand
                    break;
                case 761: icon = act.getString(R.string.wi_day_haze); //dust
                    break;
                case 762: icon = act.getString(R.string.wi_day_haze); //volcanic ash
                    break;
                case 771: icon = act.getString(R.string.wi_day_haze); //squalls
                    break;
                case 781: icon = act.getString(R.string.wi_day_haze); //tornado
                    break;

                //Clear
                case 800: icon = act.getString(R.string.wi_day_snow); //Clear
                    break;

                    //Clouds
                case 801: icon = act.getString(R.string.wi_day_sprinkle); //Few clouds
                    break;
                case 802: icon = act.getString(R.string.wi_day_sprinkle); //scattered clouds
                    break;
                case 803: icon = act.getString(R.string.wi_day_sprinkle); //broken clouds
                    break;
                case 804: icon = act.getString(R.string.wi_day_sprinkle); //overcast clouds
                    break;
            }
        }
        //Nighttime icon switch
        else
        {
            switch(id)
            {
                case 1: icon = act.getString(R.string.wi_night_clear); //Not found
                    break;

                //Thunderstorms
                case 200: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with light rain
                    break;
                case 201: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with rain
                    break;
                case 202: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with heavy rain
                    break;
                case 210: icon = act.getString(R.string.wi_day_thunderstorm); //light thunderstorm
                    break;
                case 211: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm
                    break;
                case 212: icon = act.getString(R.string.wi_day_thunderstorm); //heavy thunderstorm
                    break;
                case 221: icon = act.getString(R.string.wi_day_thunderstorm); //ragged thunderstorm
                    break;
                case 230: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with light drizzle
                    break;
                case 231: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with drizzle
                    break;
                case 232: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with heavy drizzle
                    break;

                //Drizzles
                case 300: icon = act.getString(R.string.wi_day_rain); //light intensity drizzle
                    break;
                case 301: icon = act.getString(R.string.wi_day_rain); //drizzle
                    break;
                case 302: icon = act.getString(R.string.wi_day_rain); //heavy intensity drizzle
                    break;
                case 310: icon = act.getString(R.string.wi_day_rain); //light intensity drizzle rain
                    break;
                case 311: icon = act.getString(R.string.wi_day_rain); //drizzle rain
                    break;
                case 312: icon = act.getString(R.string.wi_day_rain); //heavy intensity drizzle rain
                    break;
                case 313: icon = act.getString(R.string.wi_day_rain); //shower rain and drizzle
                    break;
                case 314: icon = act.getString(R.string.wi_day_rain); //heavy shower rain and drizzle
                    break;
                case 321: icon = act.getString(R.string.wi_day_rain); //shower drizzle
                    break;

                case 4: icon = act.getString(R.string.wi_day_fog);
                    break;

                //Rain
                case 500: icon = act.getString(R.string.wi_day_cloudy); //light rain
                    break;
                case 501: icon = act.getString(R.string.wi_day_cloudy); //moderate rain
                    break;
                case 502: icon = act.getString(R.string.wi_day_cloudy); //heavy intensity rain
                    break;
                case 503: icon = act.getString(R.string.wi_day_cloudy); //very heavy rain
                    break;
                case 504: icon = act.getString(R.string.wi_day_cloudy); //extreme rain
                    break;
                case 511: icon = act.getString(R.string.wi_day_cloudy); //freezing rain
                    break;
                case 520: icon = act.getString(R.string.wi_day_cloudy); //light intensity shower rain
                    break;
                case 521: icon = act.getString(R.string.wi_day_cloudy); //shower rain
                    break;
                case 522: icon = act.getString(R.string.wi_day_cloudy); //heavy intensity shower rain
                    break;
                case 531: icon = act.getString(R.string.wi_day_cloudy); //ragged shower rain
                    break;

                //Snow
                case 600: icon = act.getString(R.string.wi_day_lightning); //light snow
                    break;
                case 601: icon = act.getString(R.string.wi_day_lightning); //Snow
                    break;
                case 602: icon = act.getString(R.string.wi_day_lightning); //heavy snow
                    break;
                case 611: icon = act.getString(R.string.wi_day_lightning); //sleet
                    break;
                case 612: icon = act.getString(R.string.wi_day_lightning); //shower sleet
                    break;
                case 615: icon = act.getString(R.string.wi_day_lightning); //light rain and snow
                    break;
                case 616: icon = act.getString(R.string.wi_day_lightning); //rain and snow
                    break;
                case 620: icon = act.getString(R.string.wi_day_lightning); //light shower snow
                    break;
                case 621: icon = act.getString(R.string.wi_day_lightning); //shower snow
                    break;
                case 622: icon = act.getString(R.string.wi_day_lightning); //heavy shower snow
                    break;

                //Atmosphere
                case 701: icon = act.getString(R.string.wi_day_haze); //Mist
                    break;
                case 711: icon = act.getString(R.string.wi_day_haze); //smoke
                    break;
                case 721: icon = act.getString(R.string.wi_day_haze); //haze
                    break;
                case 731: icon = act.getString(R.string.wi_day_haze); //sand, dust whirls
                    break;
                case 741: icon = act.getString(R.string.wi_day_haze); //fog
                    break;
                case 751: icon = act.getString(R.string.wi_day_haze); //sand
                    break;
                case 761: icon = act.getString(R.string.wi_day_haze); //dust
                    break;
                case 762: icon = act.getString(R.string.wi_day_haze); //volcanic ash
                    break;
                case 771: icon = act.getString(R.string.wi_day_haze); //squalls
                    break;
                case 781: icon = act.getString(R.string.wi_day_haze); //tornado
                    break;

                //Clear
                case 800: icon = act.getString(R.string.wi_day_snow); //Clear
                    break;

                //Clouds
                case 801: icon = act.getString(R.string.wi_day_sprinkle); //Few clouds
                    break;
                case 802: icon = act.getString(R.string.wi_day_sprinkle); //scattered clouds
                    break;
                case 803: icon = act.getString(R.string.wi_day_sprinkle); //broken clouds
                    break;
                case 804: icon = act.getString(R.string.wi_day_sprinkle); //overcast clouds
                    break;
            }
        }
        return icon;
    }
}
