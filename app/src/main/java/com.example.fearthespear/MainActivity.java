package com.example.fearthespear;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp1;
    Button warChant,victory,fightSong, fsuCheer, qtFanfare,semUprising, gargold ;
    ImageButton play, stop;
    SeekBar seekBar;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // screen rotation on auto
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        // default
        mp1=MediaPlayer.create(MainActivity.this,R.raw.war_chant);
        warChant= findViewById(R.id.warChant);
        warChant.setOnClickListener(v -> {
            if (mp1.isPlaying())
            {
                mp1.stop();
            }
            if(mp1!=null)
            {
                mp1.release();
                mp1=new MediaPlayer();
                mp1=MediaPlayer.create(MainActivity.this, R.raw.war_chant);
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
                changeSeekbar();
            }
        });

        victory=findViewById(R.id.victory);
        victory.setOnClickListener(v -> {
            if (mp1.isPlaying())
            {
                mp1.stop();
            }
            if(mp1!=null)
            {
                mp1.release();
                mp1=new MediaPlayer();
                mp1=MediaPlayer.create(MainActivity.this, R.raw.victory_song);
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
                changeSeekbar();
            }
        });

        fightSong=findViewById(R.id.fightSong);
        fightSong.setOnClickListener(v -> {
            if (mp1.isPlaying())
            {
                mp1.stop();
            }
            if(mp1!=null)
            {
                mp1.release();
                mp1=new MediaPlayer();
                mp1=MediaPlayer.create(MainActivity.this, R.raw.fsu_fight_song);
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
                changeSeekbar();
            }
        });

        fsuCheer=findViewById(R.id.fsuCheer);
        fsuCheer.setOnClickListener(v -> {
            if (mp1.isPlaying())
            {
                mp1.stop();
            }
            if(mp1!=null)
            {
                mp1.release();
                mp1=new MediaPlayer();
                mp1=MediaPlayer.create(MainActivity.this, R.raw.fsu_cheer);
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
                changeSeekbar();
            }
        });

        qtFanfare=findViewById(R.id.qtFanfare);
        qtFanfare.setOnClickListener(v -> {
            if (mp1.isPlaying())
            {
                mp1.stop();
            }
            if(mp1!=null)
            {
                mp1.release();
                mp1=new MediaPlayer();
                mp1=MediaPlayer.create(MainActivity.this, R.raw.fanfare);
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
                changeSeekbar();
            }
        });

        semUprising=findViewById(R.id.semUprising);
        semUprising.setOnClickListener(v -> {
            if (mp1.isPlaying())
            {
                mp1.stop();
            }
            if(mp1!=null)
            {
                mp1.release();
                mp1=new MediaPlayer();
                mp1=MediaPlayer.create(MainActivity.this, R.raw.seminole_uprising);
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
                changeSeekbar();
            }
        });

        gargold=findViewById(R.id.gargold);
        gargold.setOnClickListener(v -> {
            if (mp1.isPlaying())
            {
                mp1.stop();
            }
            if(mp1!=null)
            {
                mp1.release();
                mp1=new MediaPlayer();
                mp1=MediaPlayer.create(MainActivity.this, R.raw.gold_and_garnett);
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
                changeSeekbar();
            }
        });

        // progress bar
        handler= new Handler();
        seekBar=findViewById(R.id.seekBar);

        mp1.setOnPreparedListener(mp -> seekBar.setMax(mp1.getDuration()));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                {
                    mp1.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // play pause button stop button
        play=findViewById(R.id.play);
        play.setOnClickListener(v -> {
            if(mp1.isPlaying())
            {
                mp1.pause();
                play.setBackgroundResource(R.drawable.play);
            }
            else
            {
                mp1.start();
                play.setBackgroundResource(R.drawable.pause);
            }
            changeSeekbar();
        });

        stop=findViewById(R.id.stop);
        stop.setOnClickListener(v -> {

            mp1.stop();
            play.setBackgroundResource(R.drawable.play);
            seekBar.setProgress(0);

        });

    }
    private void changeSeekbar()
    {

        if(mp1.isPlaying())
        {
            seekBar.setProgress(mp1.getCurrentPosition());

            runnable= this::changeSeekbar;
            handler.postDelayed(runnable,1000);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        //Pause your player
        mp1.pause();
        play.setBackgroundResource(R.drawable.play);
    }
}
