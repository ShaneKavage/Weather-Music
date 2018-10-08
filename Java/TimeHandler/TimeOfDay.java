package com.kavage.weathermusic.TimeHandler;

import java.util.Calendar;

public class TimeOfDay
{
    public static DayTime getTimeOfDay()
    {
        Calendar c = Calendar.getInstance();
        int CurHour = c.get(Calendar.HOUR_OF_DAY);

        if(CurHour >= 1 && CurHour < 5) { //Late Night/Very Early Morning
            return DayTime.LATENITE;

        }else if(CurHour >= 5 && CurHour < 6) { //Dawn
            return DayTime.DAWN;

        }else if(CurHour >= 6 && CurHour < 9) { //Early Morning
            return DayTime.EARLYMORNING;

        }else if(CurHour >= 9 && CurHour < 12) { //Morning
            return DayTime.MORNING;

        }else if(CurHour >= 12 && CurHour < 13) { //Noon
            return DayTime.NOON;

        }else if(CurHour >= 13 && CurHour < 17) { //Afternoon
            return DayTime.AFTERNOON;

        }else if(CurHour >= 17 && CurHour < 20) { //Evening
            return DayTime.AFTERNOON;

        }else if(CurHour >= 20 && CurHour < 22) { //Late evening
            return DayTime.LATEEVENING;

        }else if(CurHour >= 0 && CurHour < 1) { //Midnight
            return DayTime.MIDNIGHT;

        }else if(CurHour >= 22) { //night
            return DayTime.NIGHT;

        }else {
            return DayTime.ERROR;
        }
    }

    public static int returnHourOfDay()
    {
        Calendar c = Calendar.getInstance();
        int CurHour = c.get(Calendar.HOUR_OF_DAY);
        return CurHour;
    }

}


