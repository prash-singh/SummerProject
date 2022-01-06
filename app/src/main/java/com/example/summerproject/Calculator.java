package com.example.summerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Calculator extends AppCompatActivity {
    EditText e1,e2;
    TextView t1;
    Boolean next=true;
    ImageButton i1;
    TextToSpeech textToSpeech;
    String number1="",number2="";
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        t1 = findViewById(R.id.textView7);
        i1 = findViewById(R.id.imageButton8);
        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);


        //To remove inBuild keyboard popup

        e1.setShowSoftInputOnFocus(false);
        e2.setShowSoftInputOnFocus(false);
        b1 = findViewById(R.id.button9);    //1
        b2 = findViewById(R.id.button10);   //2
        b3 = findViewById(R.id.button11);   //3
        b4 = findViewById(R.id.button12);   //4
        b5 = findViewById(R.id.button13);   //5
        b6 = findViewById(R.id.button14);   //6
        b7 = findViewById(R.id.button15);   //7
        b8 = findViewById(R.id.button16);   //8
        b9 = findViewById(R.id.button17);   //9
        b10 = findViewById(R.id.button18);   //0
        b11 = findViewById(R.id.button19);   //.
        b12 = findViewById(R.id.button20);   //clear
        b13 = findViewById(R.id.button21);   //+
        b14 = findViewById(R.id.button22);   //-
        b15 = findViewById(R.id.button23);   //*
        b16 = findViewById(R.id.button24);   //'/'
        b17 = findViewById(R.id.button25);   //sin
        b18 = findViewById(R.id.button26);   //cos
        b19 = findViewById(R.id.button27);   //tan
        b20 = findViewById(R.id.button28);   //next

        //text to speech
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.ENGLISH);
                textToSpeech.setSpeechRate(0.8f);
            }
        });



        //Onclick
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Calculator.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        //1
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=1;
                    e1.setText(number1);
                }else{
                    number2+=1;
                    e2.setText(number2);
                }
            }
        });

        //2
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=2;
                    e1.setText(number1);
                }else{
                    number2+=2;
                    e2.setText(number2);
                }
            }
        });

        //3
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=3;
                    e1.setText(number1);
                }else{
                    number2+=3;
                    e2.setText(number2);
                }
            }
        });

        //4
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=4;
                    e1.setText(number1);
                }else{
                    number2+=4;
                    e2.setText(number2);
                }
            }
        });

        //5
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=5;
                    e1.setText(number1);
                }else{
                    number2+=5;
                    e2.setText(number2);
                }
            }
        });

        //6
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=6;
                    e1.setText(number1);
                }else{
                    number2+=6;
                    e2.setText(number2);
                }
            }
        });

        //7
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=7;
                    e1.setText(number1);
                }else{
                    number2+=7;
                    e2.setText(number2);
                }
            }
        });

        //8
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=8;
                    e1.setText(number1);
                }else{
                    number2+=8;
                    e2.setText(number2);
                }
            }
        });

        //9
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=9;
                    e1.setText(number1);
                }else{
                    number2+=9;
                    e2.setText(number2);
                }
            }
        });

        //0
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    number1+=0;
                    e1.setText(number1);
                }else{
                    number2+=0;
                    e2.setText(number2);
                }
            }
        });

        //.
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Calculator.this, ".", Toast.LENGTH_SHORT).show();
                if(next){
                    number1+='.';
                    e1.setText(number1);
                }else{
                    number2+='.';
                    e2.setText(number2);
                }
            }
        });

        //clear
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Calculator.this, "clear", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
                number1="";
                number2="";
                next=true;
                t1.setText("result");
            }
        });

        //+
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty() && s2.isEmpty()){
                    t1.setText("0");
                    textToSpeech.speak("Result is 0", TextToSpeech.QUEUE_FLUSH, null);
                }else if(s1.isEmpty()){
                    t1.setText(s2);
                    textToSpeech.speak("Result is " + s2, TextToSpeech.QUEUE_FLUSH, null);
                }else if(s2.isEmpty()){
                    t1.setText(s1);
                    textToSpeech.speak("Result is " + s1, TextToSpeech.QUEUE_FLUSH, null);
                }else {
                    Float f1 = Float.parseFloat(s1);
                    Float f2 = Float.parseFloat(s2);
                    float f3 = f1 + f2;
                    String s3 = Float.toString(f3);
                    t1.setText(s3);
                    textToSpeech.speak("Result is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        //-
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty() && s2.isEmpty()){
                    t1.setText("0");
                    textToSpeech.speak("Result is 0", TextToSpeech.QUEUE_FLUSH, null);
                }else if(s1.isEmpty()){
                    t1.setText(s2);
                    textToSpeech.speak("Result is " + s2, TextToSpeech.QUEUE_FLUSH, null);
                }else if(s2.isEmpty()){
                    t1.setText(s1);
                    textToSpeech.speak("Result is " + s1, TextToSpeech.QUEUE_FLUSH, null);
                }else {
                    Float f1 = Float.parseFloat(s1);
                    Float f2 = Float.parseFloat(s2);
                    Float f3 = f1 - f2;
                    String s3 = f3.toString();
                    t1.setText(s3);
                    textToSpeech.speak("Result is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        //*
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty() && s2.isEmpty()){
                    t1.setText("0");
                    textToSpeech.speak("Result is 0", TextToSpeech.QUEUE_FLUSH, null);
                }else if(s1.isEmpty()){
                    t1.setText(s2);
                    textToSpeech.speak("Result is " + s2, TextToSpeech.QUEUE_FLUSH, null);
                }else if(s2.isEmpty()){
                    t1.setText(s1);
                    textToSpeech.speak("Result is " + s1, TextToSpeech.QUEUE_FLUSH, null);
                }else {
                    Float f1 = Float.parseFloat(s1);
                    Float f2 = Float.parseFloat(s2);
                    Float f3 = f1 * f2;
                    String s3 = f3.toString();
                    t1.setText(s3);
                    textToSpeech.speak("Result is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        //'/'
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty() && s2.isEmpty()){
                    t1.setText("0");
                    textToSpeech.speak("Result is 0", TextToSpeech.QUEUE_FLUSH, null);
                }else if(s1.isEmpty()){
                    t1.setText(s2);
                    textToSpeech.speak("Result is " + s2, TextToSpeech.QUEUE_FLUSH, null);
                }else if(s2.isEmpty()){
                    t1.setText(s1);
                    textToSpeech.speak("Result is " + s1, TextToSpeech.QUEUE_FLUSH, null);
                }else {
                    Float f1 = Float.parseFloat(s1);
                    Float f2 = Float.parseFloat(s2);
                    Float f3 = f1 / f2;
                    String s3 = f3.toString();
                    t1.setText(s3);
                    textToSpeech.speak("Result is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        //sin
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                if(s1.isEmpty()){
                    t1.setText("0");
                    textToSpeech.speak("Result is 0", TextToSpeech.QUEUE_FLUSH, null);
                }else {
                    Float f1 = Float.parseFloat(s1);
                    Float f3 = (float) Math.sin(f1);
                    String s3 = f3.toString();
                    t1.setText(s3);
                    textToSpeech.speak("Result is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        //cos
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                if(s1.isEmpty()){
                    t1.setText("0");
                    textToSpeech.speak("Result is 0", TextToSpeech.QUEUE_FLUSH, null);
                }else{
                    Float f1 = Float.parseFloat(s1);
                    Float f3 = (float)  Math.cos(f1);
                    String s3 = f3.toString();
                    t1.setText(s3);
                    textToSpeech.speak("Result is "+ s3,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        //tan
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                if(s1.isEmpty()){
                    t1.setText("0");
                    textToSpeech.speak("Result is 0", TextToSpeech.QUEUE_FLUSH, null);
                }else {
                    Float f1 = Float.parseFloat(s1);
                    Float f3 = (float) Math.tan(f1);
                    String s3 = f3.toString();
                    t1.setText(s3);
                    textToSpeech.speak("Result is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next){
                    next=false;
                }else{
                    next=true;
                }
            }
        });

    }
}