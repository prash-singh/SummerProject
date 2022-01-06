package com.example.summerproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LightSensor extends AppCompatActivity implements SensorEventListener {
    TextView t1,t2;
    Button button;
    Sensor sensor;
    SensorManager sensorManager;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);

        button = findViewById(R.id.button29);
        t1 = findViewById(R.id.textView14);
        t2 = findViewById(R.id.textView15);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST);
        t2.setText("Place hand above the light sensor. If value reaches less than 3 Your phone will Vibrate.");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
                Intent i = new Intent(LightSensor.this, com.example.summerproject.Sensor.class);
                startActivity(i);
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>3){
            t1.setText("Values: " + event.values[0]);
        }else{
            t1.setText("Values: " + event.values[0]);
            vibrator.vibrate(100);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}