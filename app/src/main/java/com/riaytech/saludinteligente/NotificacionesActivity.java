package com.riaytech.saludinteligente;

import android.Manifest; // Importar
import android.content.pm.PackageManager; // Importar
import android.os.Build; // Importar
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast; // Importar

import androidx.activity.result.ActivityResultLauncher; // Importar
import androidx.activity.result.contract.ActivityResultContracts; // Importar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat; // Importar

import com.google.firebase.messaging.FirebaseMessaging;

public class NotificacionesActivity extends AppCompatActivity {

    private TextView txtToken;

    // --- AÑADIDO: Lanzador para el permiso de notificación ---
    // Esto maneja la respuesta del usuario (si acepta o deniega)
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(this, "Permisos de notificación concedidos", Toast.LENGTH_SHORT).show();
                    // Si el usuario acepta, ahora sí obtenemos el token
                    getTokenFCM();
                } else {
                    Toast.makeText(this, "Permisos de notificación denegados", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        txtToken = findViewById(R.id.txtToken);

        // --- CORREGIDO: Llamamos a nuestro nuevo método para pedir permiso ---
        askNotificationPermission();
    }

    // --- AÑADIDO: Método para pedir permiso ---
    private void askNotificationPermission() {
        // Solo se necesita en Android 13 (API 33) y superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            // Revisa si el permiso YA está concedido
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                // Permiso ya concedido, obtenemos el token
                getTokenFCM();
            } else {
                // Permiso no concedido, se lo pedimos al usuario
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        } else {
            // No se necesita permiso en versiones anteriores a Android 13
            // Obtenemos el token directamente
            getTokenFCM();
        }
    }

    // --- AÑADIDO: Tu código original, ahora en su propio método ---
    private void getTokenFCM() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                txtToken.setText("Error obteniendo token FCM");
                return;
            }
            // Muestra el token en la pantalla
            txtToken.setText("Token FCM:\n" + task.getResult());
        });
    }
}