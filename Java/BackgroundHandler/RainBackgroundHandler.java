package com.kavage.weathermusic.BackgroundHandler;

import android.app.Activity;
import android.view.View;

import com.kavage.weathermusic.R;
import com.kavage.weathermusic.TimeHandler.DayTime;
import com.kavage.weathermusic.TimeHandler.TimeOfDay;

public class RainBackgroundHandler {

    public void setBackground(Activity act) {

        View BackgroundView = act.findViewById(R.id.container);

        if(TimeOfDay.getTimeOfDay() ==  DayTime.LATENITE) { //Late Night/Very Early Morning
            BackgroundView.setBackgroundResource(R.drawable.rainy_late_night);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.DAWN) { //Dawn
            BackgroundView.setBackgroundResource(R.drawable.rainy_dawn);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EARLYMORNING) { //Early Morning
            BackgroundView.setBackgroundResource(R.drawable.rainy_early_morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MORNING) { //Morning
            BackgroundView.setBackgroundResource(R.drawable.rainy_morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NOON) { //Noon
            BackgroundView.setBackgroundResource(R.drawable.rainy_noon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.AFTERNOON) { //Afternoon
            BackgroundView.setBackgroundResource(R.drawable.rainy_afternoon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EVENING) { //Evening
            BackgroundView.setBackgroundResource(R.drawable.rainy_evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.LATEEVENING) { //Late evening
            BackgroundView.setBackgroundResource(R.drawable.rainy_late_evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MIDNIGHT) { //Midnight
            BackgroundView.setBackgroundResource(R.drawable.rainy_midnight);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NIGHT) { //night
            BackgroundView.setBackgroundResource(R.drawable.rainy_night);
        }else { //Error
            BackgroundView.setBackgroundResource(R.drawable.other);
        }
    }//End chooseRainBackground()
}