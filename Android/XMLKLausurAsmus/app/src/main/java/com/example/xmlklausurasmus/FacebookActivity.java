package com.example.xmlklausurasmus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FacebookActivity extends AppCompatActivity implements View.OnClickListener {

    // 1. Javaelemente anlegen
    EditText inputUsername, inputPassword;
    Button anmeldeBTN;
    String nameDB = "BenFB";
    String pwDB = "!Pw123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        // 2. Objekte mit dem XML verknüpfen
        inputUsername = findViewById(R.id.editTextUsername);
        inputPassword = findViewById(R.id.editTextPassword);
        anmeldeBTN = findViewById(R.id.fb_login_btn);
        anmeldeBTN.setOnClickListener(this);

        // Werte herausholen (Siehe Mainactivity Zeile 71 und 72)
        if(getIntent() != null) {
            String username = getIntent().getStringExtra("username");
            String pw = getIntent().getStringExtra("pw");

            Log.i("XXX", username);
            Log.i("XXX", pw);
        }
    }

    @Override
    public void onClick(View view) {
        String username = inputUsername.getText().toString();
        String pw = inputPassword.getText().toString();

        if (username.equals(nameDB) && pw.equals(pwDB)){
            Intent intent = new Intent(FacebookActivity.this, MainActivity.class);
            intent.putExtra("name", username);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Login Daten falsch", Toast.LENGTH_LONG).show();
        }
    }
}