package com.kavage.weathermusic;
/**
 * Shane Kavage
 * WeatherMusic - IconHandler.java
 * Its purpose it to take in the current time of day and id, and output the associated icon.
 */

import android.app.Activity;

import com.kavage.weathermusic.TimeHandler.DayTime;
import com.kavage.weathermusic.TimeHandler.TimeOfDay;

public class IconHandler
{
    public String updateIcon(Activity act, int code) {
        String icon;
        TimeOfDay currentTime = new TimeOfDay();

        //Daytime icon switch
        if( (currentTime.getTimeOfDay()  != DayTime.DAWN &&
                currentTime.getTimeOfDay()  != DayTime.EARLYMORNING &&
                currentTime.getTimeOfDay()  != DayTime.MORNING &&
                currentTime.getTimeOfDay()  != DayTime.NOON &&
                currentTime.getTimeOfDay()  != DayTime.AFTERNOON &&
                currentTime.getTimeOfDay()  != DayTime.EVENING) )
        {
            switch(code)
            {
                //Thunderstorms
                case 200: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with light rain
                    break;
                case 201: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with rain
                    break;
                case 202: icon = act.getString(R.string.wi_day_lightning); //thunderstorm with heavy rain
                    break;
                case 210: icon = act.getString(R.string.wi_day_thunderstorm); //light thunderstorm
                    break;
                case 211: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm
                    break;
                case 212: icon = act.getString(R.string.wi_day_lightning); //heavy thunderstorm
                    break;
                case 221: icon = act.getString(R.string.wi_day_lightning); //ragged thunderstorm
                    break;
                case 230: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with light drizzle
                    break;
                case 231: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with drizzle
                    break;
                case 232: icon = act.getString(R.string.wi_day_thunderstorm); //thunderstorm with heavy drizzle
                    break;

                    //Drizzles
                case 300: icon = act.getString(R.string.wi_day_sprinkle); //light intensity drizzle
                    break;
                case 301: icon = act.getString(R.string.wi_day_sprinkle); //drizzle
                    break;
                case 302: icon = act.getString(R.string.wi_day_sprinkle); //heavy intensity drizzle
                    break;
                case 310: icon = act.getString(R.string.wi_day_sprinkle); //light intensity drizzle rain
                    break;
                case 311: icon = act.getString(R.string.wi_day_sprinkle); //drizzle rain
                    break;
                case 312: icon = act.getString(R.string.wi_day_sprinkle); //heavy intensity drizzle rain
                    break;
                case 313: icon = act.getString(R.string.wi_day_sprinkle); //shower rain and drizzle
                    break;
                case 314: icon = act.getString(R.string.wi_day_sprinkle); //heavy shower rain and drizzle
                    break;
                case 321: icon = act.getString(R.string.wi_day_sprinkle); //shower drizzle
                    break;

                //Rain
                case 500: icon = act.getString(R.string.wi_day_rain); //light rain
                    break;
                case 501: icon = act.getString(R.string.wi_day_rain); //moderate rain
                    break;
                case 502: icon = act.getString(R.string.wi_day_rain); //heavy intensity rain
                    break;
                case 503: icon = act.getString(R.string.wi_day_rain); //very heavy rain
                    break;
                case 504: icon = act.getString(R.string.wi_day_rain); //extreme rain
                    break;
                case 511: icon = act.getString(R.string.wi_day_rain); //freezing rain
                    break;
                case 520: icon = act.getString(R.string.wi_day_rain); //light intensity shower rain
                    break;
                case 521: icon = act.getString(R.string.wi_day_rain); //shower rain
                    break;
                case 522: icon = act.getString(R.string.wi_day_rain); //heavy intensity shower rain
                    break;
                case 531: icon = act.getString(R.string.wi_day_rain); //ragged shower rain
                    break;

                    //Snow
                case 600: icon = act.getString(R.string.wi_day_snow); //light snow
                    break;
                case 601: icon = act.getString(R.string.wi_day_snow); //Snow
                    break;
                case 602: icon = act.getString(R.string.wi_day_snow); //heavy snow
                    break;
                case 611: icon = act.getString(R.string.wi_day_snow); //sleet
                    break;
                case 612: icon = act.getString(R.string.wi_day_snow); //shower sleet
                    break;
                case 615: icon = act.getString(R.string.wi_day_snow); //light rain and snow
                    break;
                case 616: icon = act.getString(R.string.wi_day_snow); //rain and snow
                    break;
                case 620: icon = act.getString(R.string.wi_day_snow); //light shower snow
                    break;
                case 621: icon = act.getString(R.string.wi_day_snow); //shower snow
                    break;
                case 622: icon = act.getString(R.string.wi_day_snow); //heavy shower snow
                    break;

                //Atmosphere
                case 701: icon = act.getString(R.string.wi_day_haze); //Mist
                    break;
                case 711: icon = act.getString(R.string.wi_smoke); //smoke
                    break;
                case 721: icon = act.getString(R.string.wi_day_haze); //haze
                    break;
                case 731: icon = act.getString(R.string.wi_dust); //sand, dust whirls
                    break;
                case 741: icon = act.getString(R.string.wi_day_fog); //fog
                    break;
                case 751: icon = act.getString(R.string.wi_dust); //sand
                    break;
                case 761: icon = act.getString(R.string.wi_dust); //dust
                    break;
                case 762: icon = act.getString(R.string.wi_dust); //volcanic ash
                    break;
                case 771: icon = act.getString(R.string.wi_windy); //squalls
                    break;
                case 781: icon = act.getString(R.string.wi_solar_eclipse); //tornado
                    break;

                //Clear
                case 800: icon = act.getString(R.string.wi_day_sunny); //Clear
                    break;

                    //Clouds
                case 801: icon = act.getString(R.string.wi_day_cloudy); //Few clouds
                    break;
                case 802: icon = act.getString(R.string.wi_cloudy); //scattered clouds
                    break;
                case 803: icon = act.getString(R.string.wi_cloudy); //broken clouds
                    break;
                case 804: icon = act.getString(R.string.wi_day_sunny_overcast); //overcast clouds
                    break;

                    default: icon = act.getString(R.string.wi_na);
            }
        }
        //Nighttime icon switch
        else
        {
            switch(code)
            {
                //Thunderstorms
                case 200: icon = act.getString(R.string.wi_night_alt_thunderstorm); //thunderstorm with light rain
                    break;
                case 201: icon = act.getString(R.string.wi_night_alt_thunderstorm); //thunderstorm with rain
                    break;
                case 202: icon = act.getString(R.string.wi_night_alt_lightning); //thunderstorm with heavy rain
                    break;
                case 210: icon = act.getString(R.string.wi_night_alt_thunderstorm); //light thunderstorm
                    break;
                case 211: icon = act.getString(R.string.wi_night_alt_thunderstorm); //thunderstorm
                    break;
                case 212: icon = act.getString(R.string.wi_night_alt_lightning); //heavy thunderstorm
                    break;
                case 221: icon = act.getString(R.string.wi_night_alt_lightning); //ragged thunderstorm
                    break;
                case 230: icon = act.getString(R.string.wi_night_alt_thunderstorm); //thunderstorm with light drizzle
                    break;
                case 231: icon = act.getString(R.string.wi_night_alt_thunderstorm); //thunderstorm with drizzle
                    break;
                case 232: icon = act.getString(R.string.wi_night_alt_lightning); //thunderstorm with heavy drizzle
                    break;

                //Drizzles
                case 300: icon = act.getString(R.string.wi_night_alt_sprinkle); //light intensity drizzle
                    break;
                case 301: icon = act.getString(R.string.wi_night_alt_sprinkle); //drizzle
                    break;
                case 302: icon = act.getString(R.string.wi_night_alt_sprinkle); //heavy intensity drizzle
                    break;
                case 310: icon = act.getString(R.string.wi_night_alt_sprinkle); //light intensity drizzle rain
                    break;
                case 311: icon = act.getString(R.string.wi_night_alt_sprinkle); //drizzle rain
                    break;
                case 312: icon = act.getString(R.string.wi_night_alt_sprinkle); //heavy intensity drizzle rain
                    break;
                case 313: icon = act.getString(R.string.wi_night_alt_sprinkle); //shower rain and drizzle
                    break;
                case 314: icon = act.getString(R.string.wi_night_alt_sprinkle); //heavy shower rain and drizzle
                    break;
                case 321: icon = act.getString(R.string.wi_night_alt_sprinkle); //shower drizzle
                    break;

                //Rain
                case 500: icon = act.getString(R.string.wi_night_alt_rain); //light rain
                    break;
                case 501: icon = act.getString(R.string.wi_night_alt_rain); //moderate rain
                    break;
                case 502: icon = act.getString(R.string.wi_night_alt_rain); //heavy intensity rain
                    break;
                case 503: icon = act.getString(R.string.wi_night_alt_rain); //very heavy rain
                    break;
                case 504: icon = act.getString(R.string.wi_night_alt_rain); //extreme rain
                    break;
                case 511: icon = act.getString(R.string.wi_night_alt_rain); //freezing rain
                    break;
                case 520: icon = act.getString(R.string.wi_night_alt_rain); //light intensity shower rain
                    break;
                case 521: icon = act.getString(R.string.wi_night_alt_rain); //shower rain
                    break;
                case 522: icon = act.getString(R.string.wi_night_alt_rain); //heavy intensity shower rain
                    break;
                case 531: icon = act.getString(R.string.wi_night_alt_rain); //ragged shower rain
                    break;

                //Snow
                case 600: icon = act.getString(R.string.wi_night_alt_snow); //light snow
                    break;
                case 601: icon = act.getString(R.string.wi_night_alt_snow); //Snow
                    break;
                case 602: icon = act.getString(R.string.wi_night_alt_snow); //heavy snow
                    break;
                case 611: icon = act.getString(R.string.wi_night_alt_snow); //sleet
                    break;
                case 612: icon = act.getString(R.string.wi_night_alt_snow); //shower sleet
                    break;
                case 615: icon = act.getString(R.string.wi_night_alt_snow); //light rain and snow
                    break;
                case 616: icon = act.getString(R.string.wi_night_alt_snow); //rain and snow
                    break;
                case 620: icon = act.getString(R.string.wi_night_alt_snow); //light shower snow
                    break;
                case 621: icon = act.getString(R.string.wi_night_alt_snow); //shower snow
                    break;
                case 622: icon = act.getString(R.string.wi_night_alt_snow); //heavy shower snow
                    break;

                //Atmosphere
                case 701: icon = act.getString(R.string.wi_day_haze); //Mist
                    break;
                case 711: icon = act.getString(R.string.wi_smoke); //smoke
                    break;
                case 721: icon = act.getString(R.string.wi_day_haze); //haze
                    break;
                case 731: icon = act.getString(R.string.wi_dust); //sand, dust whirls
                    break;
                case 741: icon = act.getString(R.string.wi_night_fog); //fog
                    break;
                case 751: icon = act.getString(R.string.wi_dust); //sand
                    break;
                case 761: icon = act.getString(R.string.wi_dust); //dust
                    break;
                case 762: icon = act.getString(R.string.wi_dust); //volcanic ash
                    break;
                case 771: icon = act.getString(R.string.wi_raindrop); //squalls
                    break;
                case 781: icon = act.getString(R.string.wi_solar_eclipse); //tornado
                    break;

                //Clear
                case 800: icon = act.getString(R.string.wi_night_clear); //Clear
                    break;

                //Clouds
                case 801: icon = act.getString(R.string.wi_night_alt_cloudy); //Few clouds
                    break;
                case 802: icon = act.getString(R.string.wi_night_alt_cloudy); //scattered clouds
                    break;
                case 803: icon = act.getString(R.string.wi_night_alt_partly_cloudy); //broken clouds
                    break;
                case 804: icon = act.getString(R.string.wi_night_alt_cloudy_high); //overcast clouds
                    break;

                default: icon = act.getString(R.string.wi_na);
            }
        }
        return icon;
    }
}
