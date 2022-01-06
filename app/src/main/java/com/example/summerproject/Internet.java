package com.example.summerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

public class Internet extends AppCompatActivity {
    ImageButton i1,i2,i3,i4;
    EditText e1;
    WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        i1 = findViewById(R.id.imageButton5);
        i2 = findViewById(R.id.imageButton6);
        i3 = findViewById(R.id.imageButton7);
        i4 = findViewById(R.id.imageButton9);
        e1 = findViewById(R.id.editText7);
        w1 = findViewById(R.id.webPage);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Internet.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    e1.setText("Enter url");
                }else{
                    String url = ("https://"+e1.getText().toString()).trim();
                    w1.loadUrl(url);
                }
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "https://google.com";
                w1.loadUrl(google);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebook = "https://facebook.com";
                w1.loadUrl(facebook);
            }
        });

    }
}