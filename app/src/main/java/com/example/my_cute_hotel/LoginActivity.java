package com.example.my_cute_hotel;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
        submit_button = findViewById(R.id.loginButton);

        // Button click listener
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }


    private void validateInput() {
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        // Email validation
        if (emailInput.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Enter a valid email address");
            email.requestFocus();
            return;
        }

        // Password validation
        if (passwordInput.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        if (passwordInput.length() < 6) {
            password.setError("Password must be at least 6 characters");
            password.requestFocus();
            return;
        }

        // If everything is okay
        Toast.makeText(this, "Login successful! Welcome " + emailInput, Toast.LENGTH_LONG).show();
    }
}