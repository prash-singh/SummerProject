package com.example.summerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class Phone extends AppCompatActivity {
    CountryCodePicker ccp;
    ImageButton i1;
    Button b1,b2;
    EditText e1,e2;
    String otp,phone;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        b1 = findViewById(R.id.button7);
        b2 = findViewById(R.id.button8);
        e2 = findViewById(R.id.otp);
        e1 = findViewById(R.id.phoneNo);
        i1 = findViewById(R.id.imageButton2);
        ccp = findViewById(R.id.countryCodePicker);
        ccp.registerCarrierNumberEditText(e1);
        firebaseAuth = FirebaseAuth.getInstance();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()) {
                    e1.setError("Enter phone number");
                } else {
                    if(e1.getText().toString().length() != 11){
                        Toast.makeText(Phone.this, "Enter correct phoneNo", Toast.LENGTH_SHORT).show();
                    }else {
                        phone = ccp.getFullNumberWithPlus().trim();
                        generateOTP();
                        b2.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (e2.getText().toString().isEmpty()) {
                        e2.setError("Enter otp");
                    } else if (e2.getText().toString().length() != 6) {
                        e2.setError("Enter valid otp");
                    } else {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp, e2.getText().toString());
                        signInWithPhoneAuthCredential(credential);
                    }
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Phone.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void generateOTP(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone, 60, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                otp = s;
            }
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }
            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(Phone.this, "OTP mismatched", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Phone.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Phone.this,Third.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(Phone.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}