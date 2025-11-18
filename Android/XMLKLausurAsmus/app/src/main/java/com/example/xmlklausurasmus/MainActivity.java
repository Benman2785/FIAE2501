package com.example.xmlklausurasmus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xmlklausurasmus.db.DatabaseHelperOpen;
import com.example.xmlklausurasmus.db.User;

/**
 * huhu
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //nias geheim123
    // 1. Java Objekte anlegen
    Button btnFB, btnTw;
    EditText inputUsername, inputPassword;
    TextView forgotPwLeft, forgotPwRight, signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        mehr
        zeilig
         */

        // Layout festlegen
        setContentView(R.layout.activity_main);

        // 2.  XML Elemente mit Javaobjekt verknüpfen

        btnFB = findViewById(R.id.buttonFb);
        btnFB.setOnClickListener(this);
        // anonymen Clicklistener
        /*btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("XXX", "Facebook Button anonym geklickt");
            }
        });*/

        btnTw = findViewById(R.id.buttonTw);
        btnTw.setOnClickListener(this);

        inputUsername = findViewById(R.id.editTextUsername);
        inputPassword = findViewById(R.id.editTextPw);

        forgotPwLeft = findViewById(R.id.forgotPwLeft);
        forgotPwLeft.setOnClickListener(this);
        forgotPwRight = findViewById(R.id.forgotPwRight);
        forgotPwRight.setOnClickListener(this);

        signIn = findViewById(R.id.signInTV);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnFB.getId()) {
            // neuen View laden
            // 1. Parameter von wo aufgerufen wird
            // 2. Parameter was aufgerufen werden soll (Zielactivity)
            // Expliziter Intent

            Intent fbIntent = new Intent(MainActivity.this, FacebookActivity.class);
            // Werte dem Intent mitgeben
            fbIntent.putExtra("username", "ike");
            fbIntent.putExtra("pw", "geheim123");
            startActivity(fbIntent);

            Log.i("XXX", "Facebook Button geklickt");
        }
        else if(view.getId() == btnTw.getId()) {

            Intent twIntent = new Intent(MainActivity.this, TwitterActivity.class);
            // Werte dem Intent mitgeben
            startActivity(twIntent);

            Log.i("XXX", "Twitter Button geklickt");
        }
        else if(view.getId() == forgotPwLeft.getId() || view.getId() == forgotPwRight.getId()) {
            Intent twIntent = new Intent(MainActivity.this, ForgotPwActivity.class);
            startActivity(twIntent);
            Log.i("XXX", "forgotPwLeft geklickt");
        }
        else if(view.getId() == signIn.getId()) {
            Log.i("XXX", "SignIn geklickt");

            // Werte aus EditTexts herauslesen und speichern
            String username = inputUsername.getText().toString();
            String pw = inputPassword.getText().toString();
            try (DatabaseHelperOpen dbHelperOpen = new DatabaseHelperOpen(getApplicationContext())){
                dbHelperOpen.createDataBase();
                User foundedUser = dbHelperOpen.getUserByUsername(username);
                
                // TODO überprüfen des gefundenen Userobjekts
                Intent mainIntent = new Intent(MainActivity.this, MainMenuActivity.class);
                // Werte dem Intent mitgeben
                mainIntent.putExtra("username", username);
                mainIntent.putExtra("pw", pw);
                startActivity(mainIntent);
            }catch (Exception e) {
                    throw new RuntimeException(e);
            }
        }
    }
}