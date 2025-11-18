package com.example.xmlklausurasmus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TwitterActivity extends AppCompatActivity implements View.OnClickListener {

    // 1. Javaelemente anlegen
    EditText inputUsername, inputPassword;
    Button anmeldeBTN;

    private String nameDB = "ichTw";
    private String pwDB = "Ghh123!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        // 2. Objekte mit dem XML verknüpfen
        inputUsername = findViewById(R.id.editTextUsername);
        inputPassword = findViewById(R.id.editTextPassword);
        anmeldeBTN = findViewById(R.id.tw_login_btn);
        anmeldeBTN.setOnClickListener(this);

        // anonymer ClickListener
        /*anmeldeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    public void onClick(View view) {
        String username = inputUsername.getText().toString();
        String pw = inputPassword.getText().toString();

        if(username.equals(nameDB) && pw.equals(pwDB)) {
            Intent intent = new Intent(TwitterActivity.this, MainMenuActivity.class);
            intent.putExtra("name", username);

            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Logindaten falsch", Toast.LENGTH_LONG).show();
        }
    }
}