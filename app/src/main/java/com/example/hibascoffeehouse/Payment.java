package com.example.hibascoffeehouse;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    private EditText editTextCardNumber;
    private EditText editTextExpiryDate;
    private EditText editTextCVV;
    private EditText editTextAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextExpiryDate = findViewById(R.id.editTextExpiryDate);
        editTextCVV = findViewById(R.id.editTextCVV);
        editTextAmount = findViewById(R.id.editTextAmount);
        Button buttonPay = findViewById(R.id.buttonPay);

        // Handle Pay button click
        buttonPay.setOnClickListener(v -> {
            if (areFieldsFilled()) {
                Toast.makeText(Payment.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                // Handle successful payment logic
            } else {
                Toast.makeText(Payment.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean areFieldsFilled() {
        return !editTextCardNumber.getText().toString().isEmpty() &&
                !editTextExpiryDate.getText().toString().isEmpty() &&
                !editTextCVV.getText().toString().isEmpty() &&
                !editTextAmount.getText().toString().isEmpty();
    }
}