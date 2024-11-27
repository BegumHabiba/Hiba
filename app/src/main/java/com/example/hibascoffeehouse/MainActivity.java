package com.example.hibascoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        Button buttonGetStarted = findViewById(R.id.buttonGetStarted);
        Button adminRegistration = findViewById(R.id.button_Admin);

        // Set onClickListener for "Get Started" button
        buttonGetStarted.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Showing.class);
            startActivity(intent);
        });

        // Set onClickListener for "Admin Registration" button
        adminRegistration.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Admin_Registration_Activity.class);
            startActivity(intent);
        });
    }
}
