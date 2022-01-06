package com.example.summerproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    Sensor sensor;
    SensorManager sensorManager;
    Vibrator vibrator;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        b1 = findViewById(R.id.button31);
        t1 = findViewById(R.id.textView16);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
                Intent i = new Intent(Accelerometer.this, com.example.summerproject.Sensor.class);
                startActivity(i);
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x1 = event.values[0];
        float y1 = event.values[1];
        float z1 = event.values[2];
        int x = (int) x1;
        int y = (int) y1;
        int z = (int) z1;
        if(x!=0){
            vibrator.vibrate(100);
            t1.setText("Vibration on");

        }else{
            t1.setText("Vibration Off");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}