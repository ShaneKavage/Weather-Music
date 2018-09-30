package com.kavage.weathermusic.BackgroundHandler;

import android.app.Activity;
import android.view.View;

import com.kavage.weathermusic.R;
import com.kavage.weathermusic.TimeHandler.DayTime;
import com.kavage.weathermusic.TimeHandler.TimeOfDay;

public class CloudBackgroundHandler implements IsetBackground{

    public void setBackground(Activity act) {

        View view = act.findViewById(R.id.container);
        TimeOfDay time = new TimeOfDay();

        if(time.getTimeOfDay() ==  DayTime.LATENITE) { //Late Night/Very Early Morning
            view.setBackgroundResource(R.drawable.cloudy_late_night);

        }else if(time.getTimeOfDay() ==  DayTime.DAWN) { //Dawn
            view.setBackgroundResource(R.drawable.cloudy_dawn);

        }else if(time.getTimeOfDay() ==  DayTime.EARLYMORNING) { //Early Morning
            view.setBackgroundResource(R.drawable.cloudy_early_morning);

        }else if(time.getTimeOfDay() ==  DayTime.MORNING) { //Morning
            view.setBackgroundResource(R.drawable.cloudy_morning);

        }else if(time.getTimeOfDay() ==  DayTime.NOON) { //Noon
            view.setBackgroundResource(R.drawable.cloudy_noon);

        }else if(time.getTimeOfDay() ==  DayTime.AFTERNOON) { //Afternoon
            view.setBackgroundResource(R.drawable.cloudy_afternoon);

        }else if(time.getTimeOfDay() ==  DayTime.EVENING) { //Evening
            view.setBackgroundResource(R.drawable.cloudy_evening);

        }else if(time.getTimeOfDay() ==  DayTime.LATEEVENING) { //Late evening
            view.setBackgroundResource(R.drawable.cloudy_late_evening);

        }else if(time.getTimeOfDay() ==  DayTime.MIDNIGHT) { //Midnight
            view.setBackgroundResource(R.drawable.cloudy_midnight);

        }else if(time.getTimeOfDay() ==  DayTime.NIGHT) { //night
            view.setBackgroundResource(R.drawable.cloudy_night);

        }else { //Error
            view.setBackgroundResource(R.drawable.other);
        }
    }//Enc chooseCloudBackground()
}
