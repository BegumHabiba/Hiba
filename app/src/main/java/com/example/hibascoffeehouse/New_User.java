package com.example.hibascoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class New_User extends AppCompatActivity {

    Database_Helper dbHelper;

    EditText etUsername, etEmail, etPassword, etConfirmPassword, etMobile;
    Button btnSubmit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        dbHelper = new Database_Helper(this);

        etUsername = findViewById(R.id.et_register_username);
        etEmail = findViewById(R.id.et_register_email);
        etPassword = findViewById(R.id.et_register_password);
        etConfirmPassword = findViewById(R.id.et_register_confirm_password);
        etMobile = findViewById(R.id.et_register_mobile);

        btnSubmit = findViewById(R.id.btn_submit);
        btnBack = findViewById(R.id.btn_Back);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                String mobile = etMobile.getText().toString().trim();


                if (validateInputs(username, email, password, confirmPassword, mobile)) {
                    // Insert user into database
                    boolean success = dbHelper.addUser(username, password, email, mobile);
                    if (success) {
                        Toast.makeText(New_User.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(New_User.this, Facilities.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(New_User.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(New_User.this, Showing.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateInputs(String username, String email, String password, String confirmPassword, String mobile) {
        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            return false;
        }
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (mobile.isEmpty()) {
            etMobile.setError("Mobile number is required");
            etMobile.requestFocus();
            return false;
        }
        return true;
    }

}