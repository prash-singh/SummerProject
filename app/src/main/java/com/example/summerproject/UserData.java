package com.example.summerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class UserData extends AppCompatActivity {
    ImageButton i1;
    FirebaseAuth firebaseAuth;
    TextView t1;
    Button b1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        i1 = findViewById(R.id.imageButton11);
        t1 = findViewById(R.id.textView8);
        b1 = findViewById(R.id.button5);
        imageView = findViewById(R.id.imageView3);
        firebaseAuth = FirebaseAuth.getInstance();
        String name = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getEmail();
        String number = firebaseAuth.getCurrentUser().getPhoneNumber();
        Uri img = firebaseAuth.getCurrentUser().getPhotoUrl();

        assert name != null;
        if(name.isEmpty()){
            t1.setText("User:" + number);
            imageView.setImageResource(R.drawable.ic_person);
        }else{
            t1.setText("User:" + name);
            Glide.with(this).load(img).override(300,300).into(imageView);
        }


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserData.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        //SignOut Button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent i = new Intent(UserData.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}