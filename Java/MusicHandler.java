package com.kavage.weathermusic;

import android.app.Activity;

import java.util.Calendar;

public class MusicHandler
{

    public void setMusic(int code)
    {
        Calendar c = Calendar.getInstance();
        int CurHour = c.get(Calendar.HOUR_OF_DAY);

        Activity activity = act;

        int stormCode = code/100;

        if(CurHour >= 1 && CurHour < 5) { //Late Night/Very Early Morning
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.latenight);
            return;

        }else if(CurHour >= 5 && CurHour < 6) { //Dawn
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.dawn);
            return;

        }else if(CurHour >= 6 && CurHour < 9) { //Early Morning
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.earlymorning);
            return;

        }else if(CurHour >= 9 && CurHour < 12) { //Morning
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.morning);
            return;

        }else if(CurHour >= 12 && CurHour < 13) { //Noon
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.noon);
            return;

        }else if(CurHour >= 13 && CurHour < 17) { //Afternoon
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.afternoon);
            return;

        }else if(CurHour >= 17 && CurHour < 20) { //Evening
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.evening);
            return;

        }else if(CurHour >= 20 && CurHour < 22) { //Late evening
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.lateevening);
            return;

        }else if(CurHour >= 0 && CurHour < 1) { //Midnight
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.midnight);
            return;

        }else if(CurHour >= 22) { //night
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.night);
            return;

        }else {
            activity.findViewById(R.id.container).setBackgroundResource(R.drawable.other);
            return;
        }
    }

}
