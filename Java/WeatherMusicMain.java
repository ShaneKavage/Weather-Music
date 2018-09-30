package com.kavage.weathermusic;
/**
Shane Kavage
Weather Music - WeatherMusicMain.java
This is the main view java file that creates the toolbar. Any tools/options code will be present here.
It loads up the fragment and inserts it into the same view.

 3Will need to break the blur functionality out into separate files
 **/
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class WeatherMusicMain extends AppCompatActivity {

    CityPreference city;
    boolean isVisible = true;
    boolean isMuted = false;
    boolean isBlurred = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_music_main);
        city = new CityPreference(this);

        FloatingActionMenu fam = findViewById(R.id.floatingActionMenu);
        fam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBlurred)
                {

                }
                else
                {

                }
            }

        });

        FloatingActionButton cityFab = findViewById(R.id.ChangeCityFab);
        cityFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                showInputDialog(view);
            }
        });

        final FloatingActionButton refreshFab = findViewById(R.id.RefreshFab);
        refreshFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                setCity(city.getCity());
            }
        });

        FloatingActionButton optionFab = findViewById(R.id.optionsFab);
        optionFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

            }
        });

        FloatingActionButton visibleFab = findViewById(R.id.visionFab);
        visibleFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isVisible)
                {
                    FragmentManager fm = getSupportFragmentManager();
                    Fragment frag = fm.findFragmentById(R.id.weatherFragment);
                    fm.beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .hide(frag)
                            .commit();

                    isVisible = false;

                    FloatingActionButton fabTemp = findViewById(R.id.visionFab);
                    fabTemp.setImageResource(R.drawable.visibleicon);
                    fabTemp.setLabelText("Show Weather");

                }else
                {
                    FragmentManager fm = getSupportFragmentManager();
                    Fragment frag = fm.findFragmentById(R.id.weatherFragment);
                    fm.beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .show(frag)
                            .commit();

                    isVisible = true;

                    FloatingActionButton fabTemp = findViewById(R.id.visionFab);
                    fabTemp.setImageResource(R.drawable.invisibleicon);
                    fabTemp.setLabelText("Hide Weather");
                }
            }
        });

        FloatingActionButton muteFab = findViewById(R.id.muteFab);
        muteFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(!isMuted)
                {
                    isMuted = true;

                    FloatingActionButton fabTemp = findViewById(R.id.muteFab);
                    fabTemp.setImageResource(R.drawable.unmuteicon);
                    fabTemp.setLabelText("Unmute");

                }else
                {
                    isMuted = false;

                    FloatingActionButton fabTemp = findViewById(R.id.muteFab);
                    fabTemp.setImageResource(R.drawable.muteicon);
                    fabTemp.setLabelText("Mute");
                }
            }
        });
    }

    public void showInputDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change city");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    setCity(input.getText().toString());
            }
        });
        builder.show();
    }

    public void setCity(String city){
        WeatherMusicMainFragment frag = (WeatherMusicMainFragment)
                getSupportFragmentManager().findFragmentById(R.id.weatherFragment);
        frag.updateWeatherData(city);
        new CityPreference(this).setCity(city);
    }
}
