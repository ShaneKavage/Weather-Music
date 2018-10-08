package com.kavage.weathermusic.BackgroundHandler;

import android.app.Activity;
import android.view.View;

import com.kavage.weathermusic.R;
import com.kavage.weathermusic.TimeHandler.DayTime;
import com.kavage.weathermusic.TimeHandler.TimeOfDay;

public class NormalBackgroundHandler {

    public void setBackground(Activity act) {

        View BackgroundView = act.findViewById(R.id.container);

        if(TimeOfDay.getTimeOfDay() ==  DayTime.LATENITE) { //Late Night/Very Early Morning
            BackgroundView.setBackgroundResource(R.drawable.late_night);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.DAWN) { //Dawn
            BackgroundView.setBackgroundResource(R.drawable.dawn);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EARLYMORNING) { //Early Morning
            BackgroundView.setBackgroundResource(R.drawable.early_morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MORNING) { //Morning
            BackgroundView.setBackgroundResource(R.drawable.morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NOON) { //Noon
            BackgroundView.setBackgroundResource(R.drawable.noon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.AFTERNOON) { //Afternoon
            BackgroundView.setBackgroundResource(R.drawable.afternoon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EVENING) { //Evening
            BackgroundView.setBackgroundResource(R.drawable.evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.LATEEVENING) { //Late evening
            BackgroundView.setBackgroundResource(R.drawable.late_evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MIDNIGHT) { //Midnight
            BackgroundView.setBackgroundResource(R.drawable.midnight);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NIGHT) { //night
            BackgroundView.setBackgroundResource(R.drawable.night);
        }else { //Error
            BackgroundView.setBackgroundResource(R.drawable.other);
        }
    }//End chooseNormalBackground()
}