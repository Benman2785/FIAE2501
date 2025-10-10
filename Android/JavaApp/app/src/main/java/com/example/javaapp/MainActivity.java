package com.example.javaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 1. Java Objekte anlagen:
    Button btnFB, btnTW, btnFYP01, btnFYP02, btnSI;
    EditText inputName, inputPW;

    TextView tvSI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout festlegen
        setContentView(R.layout.activity_main);

        // XML Elemente mit Javaobjekt verknüpfen
        btnFB = findViewById(R.id.facebook);
        btnFB.setOnClickListener(this);
        btnTW = findViewById(R.id.twitter);
        btnTW.setOnClickListener(this);
        btnFYP01 = findViewById(R.id.ForgotYourPassword01);
        btnFYP01.setOnClickListener(this);
        btnFYP02 = findViewById(R.id.ForgotYourPassword02);
        btnFYP02.setOnClickListener(this);
        btnSI = findViewById(R.id.SignInButton);
        btnSI.setOnClickListener(this);
        inputName = findViewById(R.id.editName);
        inputPW = findViewById(R.id.editPassword);
        tvSI = findViewById(R.id.SignIn);
        tvSI.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnFB.getId()) {
            // neuen View laden
            // 1. Parameter von wo aufgerufen wird
            // 2. Parameter was aufgerufen werden soll (Zielactivity)
            // Expliziter Intent

            Intent fbIntent = new Intent(MainActivity.this, FacebookActivity.class);
            startActivity(fbIntent);

            Log.i("XXX","Facebook Button geklickt!");
        }
        else if(view.getId() == btnTW.getId()) {

            // Intent twIntent = new Intent(MainActivity.this, TwitterActivity.class);
            // startActivity(twIntent);

            Intent twIntent = new Intent(MainActivity.this, TwitterActivity.class);
            startActivity(twIntent);

            Log.i("XXX","Twitter Button geklickt!");
        }
        else if(view.getId() == btnFYP01.getId() || view.getId() == btnFYP02.getId()) {

            // Intent fypIntent = new Intent(MainActivity.this, fypActivity.class);
            // startActivity(fypIntent);

            Log.i("XXX","ForgotYourPassword01 Button geklickt!");
        }
        else if(view.getId() == btnSI.getId()) {

            // Intent signInIntent = new Intent(MainActivity.this, signInActivity.class);
            // startActivity(signInIntent);

            Log.i("XXX","SignInButton Button geklickt!");
            // String username = inputUsername.getText().toString();
            // String pw = inputPassword.getText().toString();
        }
        else {
            Log.i("XXX", "Nix geklickt!");
        }
    }
}