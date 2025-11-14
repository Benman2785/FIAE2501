package com.example.xmlklausurstromer;

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
        inputName.setClickable(true);

        inputPW = findViewById(R.id.editPassword);
        inputPW.setClickable(true);

        tvSI = findViewById(R.id.SignIn);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnFB.getId()) {
            // neuen View laden
            // 1. Parameter von wo aufgerufen wird
            // 2. Parameter was aufgerufen werden soll (Zielactivity)
            // Expliziter Intent

            Intent fbIntent = new Intent(MainActivity.this, FacebookActivity.class);
            fbIntent.putExtra("Username","ike");
            fbIntent.putExtra("pw","123");

            startActivity(fbIntent);

            Log.i("XXX","Facebook Button geklickt!");
        }
        else if(view.getId() == btnTW.getId()) {

            Intent twIntent = new Intent(MainActivity.this, TwitterActivity.class);
            startActivity(twIntent);

            Log.i("XXX","Twitter Button geklickt!");
        }
        else if(view.getId() == btnFYP01.getId() || view.getId() == btnFYP02.getId()) {

            Intent fypIntent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            startActivity(fypIntent);

            Log.i("XXX","ForgotYourPassword01 Button geklickt!");
        }
        else if(view.getId() == btnSI.getId()) {

            Intent signInIntent = new Intent(MainActivity.this, SignInActivity.class);

            String username = inputName.getText().toString();
            String pw = inputPW.getText().toString();

            checkLogInData(username, pw, signInIntent);

            Log.i("XXX","SignInButton Button geklickt!");
        }
        else {
            Log.i("XXX", "Nix geklickt!");
        }
    }
    private void checkLogInData(String user,String pw, Intent signInIntent) {
        if (user.equalsIgnoreCase("ike") && pw.equalsIgnoreCase("123")) {
            startActivity(signInIntent);
        } else {
            System.out.println("Falsches Password!");
            Intent reject = new Intent(MainActivity.this, RejectActivity.class);
            startActivity(reject);
        }
    }
}