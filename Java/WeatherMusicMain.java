package com.kavage.weathermusic;
/**
Shane Kavage
Weather Music - WeatherMusicMain.java
This is the main view java file that creates the toolbar. Any tools/options code will be present here.
It loads up the fragment and inserts it into the same view.

 **/
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.kavage.weathermusic.BlurrHandler.BlurBuilder;
import com.kavage.weathermusic.MusicHandler.MusicManager;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherMusicMain extends AppCompatActivity {

     CityPreference city;
     boolean isVisible = true, isMuted = false, isBlurred = false, isCached = false;
     ImageView blurredBackground;
     FloatingActionMenu fam;
     int code;
     MusicManager MM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_music_main);
        city = new CityPreference(this);
        blurredBackground = findViewById(R.id.blurView);
        //MM = new MusicManager();

        fam = findViewById(R.id.floatingActionMenu);
        fam.setClosedOnTouchOutside(true);
        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened)
            {
                if(isBlurred) {
                    isBlurred = false;
                    blurredBackground.setVisibility(View.INVISIBLE);
                }else {
                    isBlurred = true;
                    takeBackgroundPicture();
                }
            }
        });

        FloatingActionButton cityFab = findViewById(R.id.ChangeCityFab);
        cityFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                fam.close(true);
                showInputDialog(view);
            }
        });

        final FloatingActionButton refreshFab = findViewById(R.id.RefreshFab);
        refreshFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                fam.close(true);
                setCity(city.getCity());
            }
        });

        FloatingActionButton optionFab = findViewById(R.id.optionsFab);
        optionFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                fam.close(true);
            }
        });

        final FloatingActionButton visibleFab = findViewById(R.id.visionFab);
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
                    visibleFab.setImageResource(R.drawable.visibleicon);
                    visibleFab.setLabelText("Show Weather");

                }else
                {
                    FragmentManager fm = getSupportFragmentManager();
                    Fragment frag = fm.findFragmentById(R.id.weatherFragment);
                    fm.beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .show(frag)
                            .commit();

                    isVisible = true;
                    visibleFab.setImageResource(R.drawable.invisibleicon);
                    visibleFab.setLabelText("Hide Weather");
                }
            }
        });

        final FloatingActionButton muteFab = findViewById(R.id.muteFab);
        muteFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(!isMuted)
                {
                    isMuted = true;
                    muteFab.setImageResource(R.drawable.unmuteicon);
                    muteFab.setLabelText("Unmute");

                }else
                {
                    isMuted = false;
                    muteFab.setImageResource(R.drawable.muteicon);
                    muteFab.setLabelText("Mute");
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
            public void onClick(DialogInterface dialog, int which)
            {
                    setCity(input.getText().toString());
            }
        });
        builder.show();
    }

    public void setCity(String city){
        WeatherMusicMainFragment frag = (WeatherMusicMainFragment)
                getSupportFragmentManager().findFragmentById(R.id.weatherFragment);
        frag.updateWeatherData(city);
        if((frag.stormcode/100) != code)
        {
            code = frag.stormcode/100;
            isCached = false;
        }
        takeBackgroundPicture();
        new CityPreference(this).setCity(city);
    }

    public void takeBackgroundPicture()
    {
        if(isBlurred)
        {
            if(!isCached)
            {
                fam.setVisibility(View.INVISIBLE);
                findViewById(R.id.weatherFragment).setVisibility(View.INVISIBLE);
                blurredBackground.setVisibility(View.INVISIBLE);
                Bitmap background = BlurBuilder.blur(findViewById(R.id.container));
                blurredBackground.setBackground(new BitmapDrawable(getResources(), background));
                fam.setVisibility(View.VISIBLE);
                isCached = true;
            }
            blurredBackground.setVisibility(View.VISIBLE);
        }

        if(isVisible)
        {
            findViewById(R.id.weatherFragment).setVisibility(View.VISIBLE);
        }
    }
}
