package com.example.summerproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16;
    ImageButton i1;
    Button b1;
    TextView t1;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        t1 = findViewById(R.id.textView13);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        r4 = findViewById(R.id.radioButton4);
        r5 = findViewById(R.id.radioButton5);
        r6 = findViewById(R.id.radioButton6);
        r7 = findViewById(R.id.radioButton7);
        r8 = findViewById(R.id.radioButton8);
        r9 = findViewById(R.id.radioButton9);
        r10 = findViewById(R.id.radioButton10);
        r11 = findViewById(R.id.radioButton11);
        r12 = findViewById(R.id.radioButton12);
        r13 = findViewById(R.id.radioButton13);
        r14 = findViewById(R.id.radioButton14);
        r15 = findViewById(R.id.radioButton15);
        r16 = findViewById(R.id.radioButton16);
        i1 = findViewById(R.id.imageButton12);
        b1 = findViewById(R.id.button30);
        result=0;



        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(r3.isChecked()){
                    result++;
                }else{
                    result--;
                }

                if(r6.isChecked()){
                    result++;
                }else{
                    result--;
                }

                if(r11.isChecked()){
                    result++;
                }else{
                    result--;
                }

                if(r14.isChecked()){
                    result++;
                }else{
                    result--;
                }
                String s = Integer.toString(result);
                t1.setText( "Score= " + s);
                result=0;
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quiz.this,Third.class);
                startActivity(i);
                finish();
            }
        });


    }
}