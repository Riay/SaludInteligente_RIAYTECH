package com.riaytech.saludinteligente;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPass;
    Button btnLogin, btnRegister;
    DatabaseHelper db;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        db = new DatabaseHelper(this);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim().toLowerCase();
            String pass = etPass.getText().toString();

            Log.d(TAG, "attemptLogin email=" + email);
            boolean ok = db.checkUser(email, pass);
            Log.d(TAG, "attemptLogin ok=" + ok);

            if (ok) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class).putExtra("email", email));
                finish();
            } else {
                String stored = db.getPasswordForEmail(email);
                Log.d(TAG, "attemptLogin storedPass=" + stored);
                Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }
}
