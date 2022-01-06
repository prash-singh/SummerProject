package com.example.summerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Sensor extends AppCompatActivity {
    Button b1,b2,b3;
    ImageButton i1;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        b1 = findViewById(R.id.button);//light
        b2 = findViewById(R.id.button4);//vibrate
        b3 = findViewById(R.id.button6);//accelerometer
        i1 = findViewById(R.id.imageButton14);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sensor.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(100);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Sensor.this,LightSensor.class);
                startActivity(i);
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sensor.this,Accelerometer.class);
                startActivity(i);
                finish();
            }
        });

    }

}