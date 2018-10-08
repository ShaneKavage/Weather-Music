package com.kavage.weathermusic.BackgroundHandler;

import android.app.Activity;
import android.view.View;

import com.kavage.weathermusic.R;
import com.kavage.weathermusic.TimeHandler.DayTime;
import com.kavage.weathermusic.TimeHandler.TimeOfDay;

public class CloudBackgroundHandler{

    public void setBackground(Activity act) {

        View backgroundView = act.findViewById(R.id.container);

        if(TimeOfDay.getTimeOfDay() ==  DayTime.LATENITE) { //Late Night/Very Early Morning
            backgroundView.setBackgroundResource(R.drawable.cloudy_late_night);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.DAWN) { //Dawn
            backgroundView.setBackgroundResource(R.drawable.cloudy_dawn);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EARLYMORNING) { //Early Morning
            backgroundView.setBackgroundResource(R.drawable.cloudy_early_morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MORNING) { //Morning
            backgroundView.setBackgroundResource(R.drawable.cloudy_morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NOON) { //Noon
            backgroundView.setBackgroundResource(R.drawable.cloudy_noon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.AFTERNOON) { //Afternoon
            backgroundView.setBackgroundResource(R.drawable.cloudy_afternoon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EVENING) { //Evening
            backgroundView.setBackgroundResource(R.drawable.cloudy_evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.LATEEVENING) { //Late evening
            backgroundView.setBackgroundResource(R.drawable.cloudy_late_evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MIDNIGHT) { //Midnight
            backgroundView.setBackgroundResource(R.drawable.cloudy_midnight);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NIGHT) { //night
            backgroundView.setBackgroundResource(R.drawable.cloudy_night);
        }else { //Error
            backgroundView.setBackgroundResource(R.drawable.other);
        }
    }//Enc chooseCloudBackground()
}