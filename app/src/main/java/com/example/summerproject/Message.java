package com.example.summerproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Message extends AppCompatActivity {
    ImageButton i1,i2;
    EditText e1,e2;
    SmsManager smsManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        i1 = findViewById(R.id.imageButton19);
        i2 = findViewById(R.id.imageButton13);
        e1 = findViewById(R.id.editTextMsg);
        e2 = findViewById(R.id.editTextPhone);
        smsManager = SmsManager.getDefault();

        ActivityCompat.requestPermissions(Message.this,new String[] {Manifest.permission.SEND_SMS,Manifest.permission.READ_PHONE_STATE}, PackageManager.PERMISSION_GRANTED);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Message.this,PhoneFeature.class);
                startActivity(i);
                finish();
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                if(e2.getText().toString().isEmpty()){
                    e2.setError("Enter PhoneNo");
                }else {
                    if (e1.getText().toString().isEmpty()) {
                        e1.setError("Empty");
                    } else {
                        ActivityCompat.requestPermissions(Message.this,new String[] {Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
                        String number = e2.getText().toString().trim();
                        String msg = e1.getText().toString();
                        smsManager.sendTextMessage(number, null, msg, null, null);
                        Toast.makeText(Message.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
                    }
                }
                }catch (Exception e){
                    Toast.makeText(Message.this, "Problem in sending", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}