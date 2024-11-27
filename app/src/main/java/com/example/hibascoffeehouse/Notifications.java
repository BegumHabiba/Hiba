package com.example.hibascoffeehouse;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Notifications extends AppCompatActivity {

    private ImageView imageViewIcon;
    private TextView textViewTitle;
    private TextView textViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        imageViewIcon = findViewById(R.id.imageViewIcon);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewText = findViewById(R.id.textViewText);

        // Set  notification details
        imageViewIcon.setImageResource(R.drawable.ic_launcher_foreground);
        textViewTitle.setText("Your Notification Title");
        textViewText.setText("Your notification message text goes here.");
    }
}