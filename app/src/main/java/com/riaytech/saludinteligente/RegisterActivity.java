package com.riaytech.saludinteligente;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtUsuario, edtPassword;
    Button btnRegistrar, btnVolverLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolverLogin = findViewById(R.id.btnVolverLogin);

        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        btnRegistrar.setOnClickListener(v -> {
            String usuario = edtUsuario.getText().toString();
            String password = edtPassword.getText().toString();

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                prefs.edit()
                        .putString("usuario", usuario)
                        .putString("password", password)
                        .apply();

                Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnVolverLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
