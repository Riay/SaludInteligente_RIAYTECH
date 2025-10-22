package com.riaytech.saludinteligente;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        String user = getIntent().getStringExtra("user");
        if (user == null) user = "Usuario";
        tvWelcome.setText("Bienvenido, " + user + "!");
    }
}
