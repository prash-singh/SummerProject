package com.example.summerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class Musix extends AppCompatActivity {
    ImageView imageView;
    ImageButton i1,i2,i3,i4;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    int[] arr = {R.raw.paani,R.raw.mirchi};
    int[]pic = {R.drawable.paani,R.drawable.mirchi};
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musix);

        imageView = findViewById(R.id.imageView);
        i1 = findViewById(R.id.imageButton4);
        i2 = findViewById(R.id.imageButton);
        i3 = findViewById(R.id.imageButton2);
        i4 = findViewById(R.id.imageButton3);
        seekBar =findViewById(R.id.seekBar);
        mediaPlayer = MediaPlayer.create(Musix.this,arr[pos]);

        //back
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent i = new Intent(Musix.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        //play and pause
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    i2.setImageResource(R.drawable.ic_play);
                    imageView.setImageResource(pic[pos]);
                    mediaPlayer.pause();
                }else{
                    i2.setImageResource(R.drawable.ic_pause);
                    imageView.setImageResource(pic[pos]);
                    mediaPlayer.start();
                }
                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        });

        //pev song
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pos == 0){
                    pos=arr.length-1;
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(Musix.this,arr[pos]);
                    imageView.setImageResource(pic[pos]);
                    mediaPlayer.start();
                }else {
                    pos--;
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(Musix.this, arr[pos]);
                    imageView.setImageResource(pic[pos]);
                    mediaPlayer.start();
                }
                seekBar.setProgress(0);
                i2.setImageResource(R.drawable.ic_pause);
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                seekBar.setMax(mediaPlayer.getDuration());
            }
        });

        //next song
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pos == arr.length-1){
                    pos=0;
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(Musix.this,arr[pos]);
                    imageView.setImageResource(pic[pos]);
                    mediaPlayer.start();
                }else {
                    pos++;
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(Musix.this, arr[pos]);
                    imageView.setImageResource(pic[pos]);
                    mediaPlayer.start();
                }
                seekBar.setProgress(0);
                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                i2.setImageResource(R.drawable.ic_pause);
            }
        });



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        songEnd();

    }

    public void songEnd(){
        if(mediaPlayer.getCurrentPosition() == mediaPlayer.getDuration()){
            i2.setImageResource(R.drawable.ic_play);
        }
    }
}