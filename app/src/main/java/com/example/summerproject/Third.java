package com.example.summerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class Third extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    CardView c1,c2,c3,c4,c5,c6,c7,c8;
    ImageButton c9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        c1 = findViewById(R.id.cardInternet);
        c2 = findViewById(R.id.cardSensor);
        c3 = findViewById(R.id.cardMedia);
        c4 = findViewById(R.id.cardMusix);
        c5 = findViewById(R.id.cardMobile);
        c6 = findViewById(R.id.cardClick);
        c7 = findViewById(R.id.cardCalculator);
        c8 = findViewById(R.id.cardQuiz);
        c9 = findViewById(R.id.cardMe);


        firebaseAuth = FirebaseAuth.getInstance();


        //Internet
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Internet.class);
                startActivity(i);
                finish();
            }
        });

        //Sensor
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Sensor.class);
                startActivity(i);
                finish();
                Toast.makeText(Third.this, "Sensor", Toast.LENGTH_SHORT).show();
            }
        });

        //MediaPlayer
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,MediaPlayer.class);
                startActivity(i);
                finish();
                Toast.makeText(Third.this, "MediaPlayer was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //MusicPlayer
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Musix.class);
                startActivity(i);
                finish();
            }
        });

        //Mobile Feature
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,PhoneFeature.class);
                startActivity(i);
                finish();
            }
        });

        //Click Pic
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Click.class);
                startActivity(i);
                finish();
                Toast.makeText(Third.this, "Click picture", Toast.LENGTH_SHORT).show();
            }
        });

        //Calculator
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Calculator.class);
                startActivity(i);
                finish();
           }
        });

        //Quiz
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Quiz.class);
                startActivity(i);
                finish();
            }
        });

        //User(Me)
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,UserData.class);
                startActivity(i);
                finish();
            }
        });

    }
}