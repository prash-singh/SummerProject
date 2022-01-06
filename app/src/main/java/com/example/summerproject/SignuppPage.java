package com.example.summerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignuppPage extends AppCompatActivity {
    Button b1;
    ImageButton b2;
    ProgressBar p1;
    EditText e1,e2,e3,e4;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupp_page);

        b1 = findViewById(R.id.button9);
        b2 = findViewById(R.id.imageButton);
        p1 = findViewById(R.id.progressBar3);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setVisibility(View.VISIBLE);
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                if(s1.isEmpty()){
                    p1.setVisibility(View.INVISIBLE);
                    e1.setError("Enter name");
                }else if(s2.isEmpty() || !s2.contains("@")){
                    p1.setVisibility(View.INVISIBLE);
                    e2.setError("Enter email");
                }else{
                    if(s3.isEmpty()){
                        p1.setVisibility(View.INVISIBLE);
                        e3.setError("Enter Password");
                    }else if(s4.isEmpty()){
                        p1.setVisibility(View.INVISIBLE);
                        e4.setError("Enter PhoneNumber");
                    }
                    else{ 
                        firebaseAuth.createUserWithEmailAndPassword(s2,s3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    p1.setVisibility(View.INVISIBLE);
                                    firebaseAuth.signOut();
                                    databaseReference = firebaseDatabase.getReference("users");
                                    User user = new User(s1, s2, s3,s4);
                                    databaseReference.child(s4).setValue(user);
                                    Intent i = new Intent(SignuppPage.this, MainActivity.class);
                                    i.putExtra("name",s1);
                                    startActivity(i);
                                    Toast.makeText(SignuppPage.this, "User Created", Toast.LENGTH_SHORT).show();
                                }else{
                                    p1.setVisibility(View.INVISIBLE);
                                    firebaseAuth.signOut();
                                    Toast.makeText(SignuppPage.this, "User already exists", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(SignuppPage.this,MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }
                        });
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignuppPage.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}