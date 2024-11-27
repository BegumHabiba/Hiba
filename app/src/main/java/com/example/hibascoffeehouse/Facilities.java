package com.example.hibascoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Facilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);

        Button buttonMenuDisplay = findViewById(R.id.buttonMenuDisplay);
        Button buttonNotifications = findViewById(R.id.buttonNotifications);
        Button buttonOrderPlacement = findViewById(R.id.buttonOrderPlacement);
        Button buttonPayment = findViewById(R.id.buttonPayment);
        Button buttonReservation = findViewById(R.id.buttonReservation);

        buttonMenuDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Facilities.this, Menu_Display.class);
                startActivity(intent);
            }
        });

        buttonNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Facilities.this, Notifications.class);
                startActivity(intent);
            }
        });

        buttonOrderPlacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Facilities.this, Order_Placement.class);
                startActivity(intent);
            }
        });

        buttonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Facilities.this, Payment.class);
                startActivity(intent);
            }
        });

        buttonReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Facilities.this, Reservations.class);
                startActivity(intent);
            }
        });
    }
}