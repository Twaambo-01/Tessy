package com.example.my_cute_hotel;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password, confirmPassword;
    Button submit_button, continueWithGoogle, continueWithFacebook, continueWithApple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        confirmPassword = findViewById(R.id.confirmpasswordInput);
        submit_button = findViewById(R.id.signupButton);

        // Click listener for Register button
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
        String confirmPasswordInput = confirmPassword.getText().toString().trim();

        // Email validation
        if (emailInput.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email");
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

        // Confirm password validation
        if (!passwordInput.equals(confirmPasswordInput)) {
            confirmPassword.setError("Passwords do not match");
            confirmPassword.requestFocus();
            return;
        }

        // If everything is okay
        Toast.makeText(this, "Registration successful for: " + emailInput, Toast.LENGTH_LONG).show();
    }
}