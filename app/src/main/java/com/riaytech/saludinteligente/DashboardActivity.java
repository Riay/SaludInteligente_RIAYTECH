package com.riaytech.saludinteligente;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DashboardActivity extends AppCompatActivity {

    private Button btnMonitoreo, btnConsejos, btnCamara, btnGeo, btnNotificaciones, btnCerrar;

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(this, "Permisos de notificación concedidos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No recibirás notificaciones", Toast.LENGTH_SHORT).show();
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnMonitoreo = findViewById(R.id.btnMonitoreo);
        btnConsejos = findViewById(R.id.btnConsejos);
        btnCamara = findViewById(R.id.btnCamara);
        btnGeo = findViewById(R.id.btnGeo);
        btnNotificaciones = findViewById(R.id.btnNotificaciones);
        btnCerrar = findViewById(R.id.btnCerrar);

        btnMonitoreo.setOnClickListener(v ->
                startActivity(new Intent(this, MonitoreoSaludActivity.class)));

        btnConsejos.setOnClickListener(v ->
                startActivity(new Intent(this, ConsejosSaludActivity.class)));

        btnCamara.setOnClickListener(v ->
                startActivity(new Intent(this, CamaraInteligenteActivity.class)));

        btnGeo.setOnClickListener(v ->
                startActivity(new Intent(this, GeolocalizacionActivity.class)));

        btnNotificaciones.setOnClickListener(v ->
                startActivity(new Intent(this, NotificacionesActivity.class)));

        btnCerrar.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        askNotificationPermission();
    }

    private void askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
            } else {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        }
    }
}