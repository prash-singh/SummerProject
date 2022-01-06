package com.example.summerproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class  MainActivity extends AppCompatActivity {
    FloatingActionButton b3,b4;
    EditText e1,e2;
    Button b1,b2;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText5);
        e2 = findViewById(R.id.editText6);
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.phone);
        p1 = findViewById(R.id.progressBar);
        b4 = findViewById(R.id.googleSignin);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("663769227518-p65ed23rcl93jauotq9sfh5q18kcmn0b.apps.googleusercontent.com").requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(MainActivity.this,googleSignInOptions);
        googleSignInClient.signOut();

        firebaseAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setVisibility(View.VISIBLE);
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty() || !s1.contains("@")){
                    p1.setVisibility(View.INVISIBLE);
                    e1.setError("Enter Email");
                }else{
                    if(s2.isEmpty()){
                        p1.setVisibility(View.INVISIBLE);
                        e2.setError("Enter password");
                    }else{
                        firebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                p1.setVisibility(View.INVISIBLE);
                                if(task.isSuccessful()){
                                    Intent i = new Intent(MainActivity.this,Third.class);
                                    startActivity(i);
                                    finish();
                                }else{
                                    Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
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
                Intent i = new Intent(MainActivity.this,SignuppPage.class);
                startActivity(i);
                finish();
                Toast.makeText(MainActivity.this, "Create Account", Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Phone.class);
                startActivity(i);
                finish();
                Toast.makeText(MainActivity.this, "Enter Phone No", Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setVisibility(View.VISIBLE);
                Intent i = googleSignInClient.getSignInIntent();
                startActivityForResult(i,100);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!= null){
            Intent i = new Intent(MainActivity.this,Third.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            if(signInAccountTask.isSuccessful()){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                try{
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if(googleSignInAccount != null){
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    p1.setVisibility(View.INVISIBLE);
                                    Intent j = new Intent(MainActivity.this,Third.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(j);
                                }else{
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }catch (ApiException e){
                    e.printStackTrace();
                    p1.setVisibility(View.INVISIBLE);


                }
            }else{
                Toast.makeText(this, "SOME ERROR", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            p1.setVisibility(View.INVISIBLE);
        }
    }
}