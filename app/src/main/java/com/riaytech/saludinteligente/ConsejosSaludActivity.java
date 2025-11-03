package com.riaytech.saludinteligente;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConsejosSaludActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos_salud);

        TextView consejos = findViewById(R.id.txtConsejos);
        consejos.setText("💧 Bebe suficiente agua.\n🏃‍♂️ Haz ejercicio 30 minutos diarios.\n🍎 Come frutas y verduras.\n😴 Duerme 8 horas diarias.");
    }
}
