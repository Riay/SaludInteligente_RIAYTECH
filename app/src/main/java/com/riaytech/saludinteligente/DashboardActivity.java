package com.riaytech.saludinteligente;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    TextView tvWelcome;
    Button btnMonitor, btnTips, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvWelcome = findViewById(R.id.tvWelcome);
        btnMonitor = findViewById(R.id.btnMonitor);
        btnTips = findViewById(R.id.btnTips);
        btnLogout = findViewById(R.id.btnLogout);

        String email = getIntent().getStringExtra("email");
        tvWelcome.setText("Bienvenido: " + email);

        btnMonitor.setOnClickListener(v -> {
            Toast.makeText(this, "Monitoreo de salud (demo)", Toast.LENGTH_SHORT).show();
        });

        btnTips.setOnClickListener(v -> {
            Toast.makeText(this, "Descargando consejos (demo Retrofit)", Toast.LENGTH_SHORT).show();
            // Aquí se puede agregar la llamada real con Retrofit
        });

        btnLogout.setOnClickListener(v -> finish());
    }
}
