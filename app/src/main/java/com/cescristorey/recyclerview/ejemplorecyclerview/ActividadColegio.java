package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActividadColegio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_equipo);

        Bundle datos = this.getIntent().getExtras();

        int c = datos.getInt("cod_colegio");
        String n = datos.getString("nombre");
        String d = datos.getString("direccion");


        TextView cod_colegio = findViewById(R.id.textViewCod_Colegio);
        TextView nombre = findViewById(R.id.textViewNombre);
        TextView direccion = findViewById(R.id.textViewDireccion);

        cod_colegio.setText(Integer.toString(c));
        nombre.setText(n);
        direccion.setText(d);
    }
}