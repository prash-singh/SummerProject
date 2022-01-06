package com.example.summerproject;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

public class PhoneFeature extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5;
    ImageButton i1;
    ImageView i2,i3,i4,i6;
    EditText e1;
    CameraManager cameraManager;
    Boolean check = true;
    WifiManager manager;
    Boolean on= true;
    BluetoothAdapter bluetoothAdapter;
    Boolean blue=true;
    Vibrator v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_feature);

        ActivityCompat.requestPermissions(PhoneFeature.this,new String[] {Manifest.permission.CALL_PHONE}, PackageManager.PERMISSION_GRANTED);

        i1 = findViewById(R.id.imageButton10);
        i2 = findViewById(R.id.bluetoothImage);
        i3 = findViewById(R.id.wifiImage);
        i4 = findViewById(R.id.flashImage);
        i6 = findViewById(R.id.imageCall);
        c1 = findViewById(R.id.cardBluetooth);
        c2 = findViewById(R.id.cardWifi);
        c3 = findViewById(R.id.cardFlash);
        c4 = findViewById(R.id.cardMessage);
        c5 = findViewById(R.id.cardCall);
        e1 = findViewById(R.id.editTextPhone2);
        v1 = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        manager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        cameraManager= (CameraManager)getSystemService(CAMERA_SERVICE);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PhoneFeature.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        //Bluetooth
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.vibrate(100);
                if(blue){
                    bluetoothAdapter.enable();
                    blue=false;
                    Toast.makeText(PhoneFeature.this, "Bluetooth is on", Toast.LENGTH_SHORT).show();
                    i2.setImageResource(R.drawable.ic_bluetooth_disabled);
                }else{
                    bluetoothAdapter.disable();
                    blue=true;
                    Toast.makeText(PhoneFeature.this, "Bluetooth is off", Toast.LENGTH_SHORT).show();
                    i2.setImageResource(R.drawable.ic_bluetooth);
                }

            }
        });

        //Wifi
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.vibrate(100);
                if(on){
                    manager.setWifiEnabled(true);
                    Toast.makeText(PhoneFeature.this, "Wifi on", Toast.LENGTH_SHORT).show();
                    i3.setImageResource(R.drawable.ic_wifi_off);
                    on = false;
                }else{
                    manager.setWifiEnabled(false);
                    Toast.makeText(PhoneFeature.this, "Wifi off", Toast.LENGTH_SHORT).show();
                    i3.setImageResource(R.drawable.ic_wifi);
                    on=true;
                }
            }
        });

        //Flash
        c3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                v1.vibrate(100);
                String f = null;
                if(check){
                    try {
                        f = cameraManager.getCameraIdList()[0];
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        cameraManager.setTorchMode(f,true);
                        check=false;
                        i4.setImageResource(R.drawable.ic_flash_off);
                        Toast.makeText(PhoneFeature.this, "Flash on", Toast.LENGTH_SHORT).show();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        f = cameraManager.getCameraIdList()[0];
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        cameraManager.setTorchMode(f,false);
                        check=true;
                        i4.setImageResource(R.drawable.ic_flash);
                        Toast.makeText(PhoneFeature.this, "Flash off", Toast.LENGTH_SHORT).show();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //Message
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.vibrate(100);
                Intent i = new Intent(PhoneFeature.this,Message.class);
                startActivity(i);
                finish();
            }
        });

        //Call
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = e1.getText().toString().trim();
                v1.vibrate(100);
                if(no.isEmpty() && no.length()!=10){
                    e1.setError("Enter number");
                }else {
                    try{
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse("tel:"+no));
                        startActivity(call);
                        Toast.makeText(PhoneFeature.this, "Calling", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        Toast.makeText(PhoneFeature.this, "Error while calling " + no.length(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}