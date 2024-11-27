package com.example.hibascoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Registration_Activity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Database_Helper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration); // Set the layout file

        databaseHelper = new Database_Helper(this);


        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button submitBtn = findViewById(R.id.submitBtn);
        Button backBtn = findViewById(R.id.backBtn);

        //  for back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create  intent  back to the parent activity
                Intent intent = new Intent(Admin_Registration_Activity.this, MainActivity.class); // Replace ParentActivity with your actual parent activity class
                startActivity(intent);
            }
        });

        //  for admin login button
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim(); // Trim to remove  spaces
                String password = passwordEditText.getText().toString().trim();


                if (validateInputs(username, password)) {
                    // Check if the  match
                    if (databaseHelper.checkAdmin(username, password)) {
                        Toast.makeText(Admin_Registration_Activity.this, "Admin Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Admin_Registration_Activity.this, Admin_Home.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Admin_Registration_Activity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // Method
    private boolean validateInputs(String username, String password) {
        if (username.isEmpty()) {
            usernameEditText.setError("Admin name is required");
            usernameEditText.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            passwordEditText.setError("Password is required");
            passwordEditText.requestFocus();
            return false;
        }
        return true;
    }
}