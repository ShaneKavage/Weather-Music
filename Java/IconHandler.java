package com.kavage.weathermusic;
/**
 * Shane Kavage
 * WeatherMusic - IconHandler.java
 * Its purpose it to take in the current time of day and id, and output the associated icon.
 */

import android.app.Activity;

import com.kavage.weathermusic.TimeHandler.DayTime;
import com.kavage.weathermusic.TimeHandler.TimeOfDay;

import java.util.HashMap;

public class IconHandler
{
    protected String icon;
    private HashMap<Integer, String> DayIconmap = new HashMap<Integer, String>();
    private HashMap<Integer, String> NightIconmap = new HashMap<Integer, String>();

    protected IconHandler(Activity act)
    {
        fillDaymap(act);
        fillNightmap(act);
    }

    public String updateIcon(Activity act, int code)
    {
        TimeOfDay currentTime = new TimeOfDay();
        //Daytime icon switch
        if ((currentTime.getTimeOfDay() != DayTime.DAWN &&
                currentTime.getTimeOfDay() != DayTime.EARLYMORNING &&
                currentTime.getTimeOfDay() != DayTime.MORNING &&
                currentTime.getTimeOfDay() != DayTime.NOON &&
                currentTime.getTimeOfDay() != DayTime.AFTERNOON &&
                currentTime.getTimeOfDay() != DayTime.EVENING))
        {
            icon = DayIconmap.get(code);
        } else {
            icon = NightIconmap.get(code);
        }
        return icon;
    }//End UpdateIcon

    private void fillDaymap(Activity act)
    {
        //ThunderStorms
        DayIconmap.put(200,act.getString(R.string.wi_day_thunderstorm));
        DayIconmap.put(201,act.getString(R.string.wi_day_thunderstorm));
        DayIconmap.put(202,act.getString(R.string.wi_day_thunderstorm));
        DayIconmap.put(210,act.getString(R.string.wi_day_thunderstorm));
        DayIconmap.put(211,act.getString(R.string.wi_day_thunderstorm));
        DayIconmap.put(212,act.getString(R.string.wi_day_lightning));
        DayIconmap.put(221,act.getString(R.string.wi_day_lightning));
        DayIconmap.put(230,act.getString(R.string.wi_day_thunderstorm));
        DayIconmap.put(231,act.getString(R.string.wi_day_thunderstorm));
        DayIconmap.put(232,act.getString(R.string.wi_day_thunderstorm));

        //Drizzle
        DayIconmap.put(300,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(301,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(302,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(310,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(311,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(312,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(313,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(314,act.getString(R.string.wi_day_sprinkle));
        DayIconmap.put(321,act.getString(R.string.wi_day_sprinkle));

        //Rains
        DayIconmap.put(500, act.getString(R.string.wi_day_rain));
        DayIconmap.put(501, act.getString(R.string.wi_day_rain));
        DayIconmap.put(502, act.getString(R.string.wi_day_rain));
        DayIconmap.put(503, act.getString(R.string.wi_day_rain));
        DayIconmap.put(504, act.getString(R.string.wi_day_rain));
        DayIconmap.put(511, act.getString(R.string.wi_day_rain));
        DayIconmap.put(520, act.getString(R.string.wi_day_rain));
        DayIconmap.put(521, act.getString(R.string.wi_day_rain));
        DayIconmap.put(522, act.getString(R.string.wi_day_rain));
        DayIconmap.put(531, act.getString(R.string.wi_day_rain));

        //Snow
        DayIconmap.put(601,act.getString(R.string.wi_day_snow));
        DayIconmap.put(602,act.getString(R.string.wi_day_snow));
        DayIconmap.put(611,act.getString(R.string.wi_day_snow));
        DayIconmap.put(612,act.getString(R.string.wi_day_snow));
        DayIconmap.put(615,act.getString(R.string.wi_day_snow));
        DayIconmap.put(616,act.getString(R.string.wi_day_snow));
        DayIconmap.put(620,act.getString(R.string.wi_day_snow));
        DayIconmap.put(621,act.getString(R.string.wi_day_snow));
        DayIconmap.put(622,act.getString(R.string.wi_day_snow));
        DayIconmap.put(600,act.getString(R.string.wi_day_snow));

        //Atmosphere
        DayIconmap.put(701,act.getString(R.string.wi_day_haze));
        DayIconmap.put(711,act.getString(R.string.wi_smoke));
        DayIconmap.put(721,act.getString(R.string.wi_day_haze));
        DayIconmap.put(731,act.getString(R.string.wi_dust));
        DayIconmap.put(741,act.getString(R.string.wi_day_fog));
        DayIconmap.put(751,act.getString(R.string.wi_dust));
        DayIconmap.put(761,act.getString(R.string.wi_dust));
        DayIconmap.put(762,act.getString(R.string.wi_dust));
        DayIconmap.put(771,act.getString(R.string.wi_windy));
        DayIconmap.put(781,act.getString(R.string.wi_solar_eclipse));

        //Clear
        DayIconmap.put(800,act.getString(R.string.wi_day_sunny));

        //Clouds
        DayIconmap.put(801,act.getString(R.string.wi_day_cloudy));
        DayIconmap.put(802,act.getString(R.string.wi_cloudy));
        DayIconmap.put(803,act.getString(R.string.wi_cloudy));
        DayIconmap.put(804,act.getString(R.string.wi_day_sunny_overcast));

        DayIconmap.put(0,act.getString(R.string.wi_na));
    }//End FillDaymap

    private void fillNightmap(Activity act)
    {
        //ThunderStorms
        NightIconmap.put(200,act.getString(R.string.wi_night_alt_thunderstorm));
        NightIconmap.put(201,act.getString(R.string.wi_night_alt_thunderstorm));
        NightIconmap.put(202,act.getString(R.string.wi_night_alt_lightning));
        NightIconmap.put(210,act.getString(R.string.wi_night_alt_thunderstorm));
        NightIconmap.put(211,act.getString(R.string.wi_night_alt_thunderstorm));
        NightIconmap.put(212,act.getString(R.string.wi_night_alt_lightning));
        NightIconmap.put(221,act.getString(R.string.wi_night_alt_lightning));
        NightIconmap.put(230,act.getString(R.string.wi_night_alt_thunderstorm));
        NightIconmap.put(231,act.getString(R.string.wi_night_alt_thunderstorm));
        NightIconmap.put(232,act.getString(R.string.wi_night_alt_lightning));

        //Drizzles
        NightIconmap.put(300,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(301,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(302,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(310,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(311,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(312,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(313,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(314,act.getString(R.string.wi_night_alt_sprinkle));
        NightIconmap.put(321,act.getString(R.string.wi_night_alt_sprinkle));

        //Rains
        NightIconmap.put(500, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(501, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(502, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(503, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(504, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(511, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(520, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(521, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(522, act.getString(R.string.wi_night_alt_rain));
        NightIconmap.put(531, act.getString(R.string.wi_night_alt_rain));

        //Snow
        NightIconmap.put(601,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(602,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(611,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(612,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(615,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(616,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(620,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(621,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(622,act.getString(R.string.wi_night_alt_snow));
        NightIconmap.put(600,act.getString(R.string.wi_night_alt_snow));

        //Atmosphere
        NightIconmap.put(701,act.getString(R.string.wi_day_haze));
        NightIconmap.put(711,act.getString(R.string.wi_smoke));
        NightIconmap.put(721,act.getString(R.string.wi_day_haze));
        NightIconmap.put(731,act.getString(R.string.wi_dust));
        NightIconmap.put(741,act.getString(R.string.wi_night_fog));
        NightIconmap.put(751,act.getString(R.string.wi_dust));
        NightIconmap.put(761,act.getString(R.string.wi_dust));
        NightIconmap.put(762,act.getString(R.string.wi_dust));
        NightIconmap.put(771,act.getString(R.string.wi_windy));
        NightIconmap.put(781,act.getString(R.string.wi_solar_eclipse));

        //Clear
        NightIconmap.put(800,act.getString(R.string.wi_night_clear));
         //Clouds
        NightIconmap.put(801,act.getString(R.string.wi_night_alt_cloudy));
        NightIconmap.put(802,act.getString(R.string.wi_night_alt_cloudy));
        NightIconmap.put(803,act.getString(R.string.wi_night_alt_partly_cloudy));
        NightIconmap.put(804,act.getString(R.string.wi_night_alt_partly_cloudy));

        NightIconmap.put(0,act.getString(R.string.wi_na));
    }//End FillNightmap()
}

