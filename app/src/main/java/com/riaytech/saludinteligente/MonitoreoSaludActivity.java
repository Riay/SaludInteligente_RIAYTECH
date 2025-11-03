package com.riaytech.saludinteligente;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MonitoreoSaludActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoreo_salud);

        TextView txt = findViewById(R.id.txtMonitoreo);
        txt.setText("Aquí podrás monitorear tus signos vitales, frecuencia cardiaca y otros datos de salud.");
    }
}
