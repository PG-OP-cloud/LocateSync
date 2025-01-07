package com.locatesync;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
    }

    public void onLoginClick(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (isValidCredentials(email, password)) {
            // Simulate login, you can replace this with actual authentication logic
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidCredentials(String email, String password) {
        // Implement actual validation with backend (or local storage)
        return email.equals("test@locatesync.com") && password.equals("password123");
    }
}
