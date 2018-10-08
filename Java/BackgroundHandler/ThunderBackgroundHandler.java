package com.kavage.weathermusic.BackgroundHandler;

import android.app.Activity;
import android.view.View;

import com.kavage.weathermusic.R;
import com.kavage.weathermusic.TimeHandler.DayTime;
import com.kavage.weathermusic.TimeHandler.TimeOfDay;

public class ThunderBackgroundHandler{

    public void setBackground(Activity act) {

        View BackgroundView = act.findViewById(R.id.container);

        if(TimeOfDay.getTimeOfDay() ==  DayTime.LATENITE) { //Late Night/Very Early Morning
            BackgroundView.setBackgroundResource(R.drawable.thunder_late_night);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.DAWN) { //Dawn
            BackgroundView.setBackgroundResource(R.drawable.thunder_dawn);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EARLYMORNING) { //Early Morning
            BackgroundView.setBackgroundResource(R.drawable.thunder_early_morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MORNING) { //Morning
            BackgroundView.setBackgroundResource(R.drawable.thunder_morning);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NOON) { //Noon
            BackgroundView.setBackgroundResource(R.drawable.thunder_noon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.AFTERNOON) { //Afternoon
            BackgroundView.setBackgroundResource(R.drawable.thunder_afternoon);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.EVENING) { //Evening
            BackgroundView.setBackgroundResource(R.drawable.thunder_evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.LATEEVENING) { //Late evening
            BackgroundView.setBackgroundResource(R.drawable.thunder_late_evening);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.MIDNIGHT) { //Midnight
            BackgroundView.setBackgroundResource(R.drawable.thunder_midnight);
        }else if(TimeOfDay.getTimeOfDay() ==  DayTime.NIGHT) { //night
            BackgroundView.setBackgroundResource(R.drawable.thunder_night);
        }else { //Error
            BackgroundView.setBackgroundResource(R.drawable.other);
        }
    }//End chooseThunderBackground()
}