package com.example.hibascoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Button btnInsertCoffee = findViewById(R.id.btn_insert_product);
        Button btnViewCoffee = findViewById(R.id.btn_view_product);

        btnInsertCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInsert = new Intent(Admin_Home.this,InsertCoffeeActivity.class);
                startActivity(intentInsert);
            }
        });

        btnViewCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentView = new Intent(Admin_Home.this, ViewCoffeeActivity.class);
                startActivity(intentView);
            }
        });
    }
}