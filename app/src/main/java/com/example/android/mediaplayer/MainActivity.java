package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private int maxVolume = 50;
    private int currVolume = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the song object
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.goneaway);

        // Find the view that shows the play button
        Button playbutton = (Button) findViewById(R.id.playbutton);
        playbutton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying() == false) {
                    mediaPlayer.start();
                }
            }
        });

        // Find the view that shows the pause button
        Button pausebutton = (Button) findViewById(R.id.pausebutton);
        pausebutton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        // Find the view that shows the stop button
        Button stopbutton = (Button) findViewById(R.id.stopbutton);
        stopbutton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.goneaway);
                }

            }
        });

        // Find the view that shows the stop button
        Button volumedown = (Button) findViewById(R.id.volumdown);
        volumedown.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                // decrease volume
                if (currVolume > 0) {
                    currVolume -= 1;
                }
                float log1=(float)(Math.log(maxVolume-currVolume)/Math.log(maxVolume));
                mediaPlayer.setVolume(1-log1, 1-log1);
            }
        });

        // Find the view that shows the stop button
        Button volumeup = (Button) findViewById(R.id.volumeup);
        volumeup.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                // increase volume
                if (currVolume < maxVolume) {
                    currVolume += 1;
                }
                float log1=(float)(Math.log(maxVolume-currVolume)/Math.log(maxVolume));
                mediaPlayer.setVolume(1-log1, 1-log1);
            }
        });


        System.out.println("6");
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    public void audioPlayer(String path, String fileName){
        //set up MediaPlayer
        MediaPlayer mp = new MediaPlayer();

        try {
            mp.setDataSource(path+"/"+fileName);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mp.start();
    }



}
