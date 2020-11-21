package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroducirColegioActivity extends AppCompatActivity {

    BaseDeDatos sqlile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir_colegio);


        sqlile = new BaseDeDatos(this, "baseDatos", null, 1);
        final TextView text_cod_colegio = findViewById(R.id.tIntroducirCod_colegio);
        final TextView text_nombre = findViewById(R.id.tIntroducirNombre);

        final Button boton_aceptar = findViewById(R.id.buttonAceptar);

        boton_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase bd = sqlile.getWritableDatabase();
                String tabla = "Colegio";

                int cod_colegi = Integer.valueOf(text_cod_colegio.getText().toString());
                String nombre_1 = text_nombre.getText().toString();
                String direccion_1 = "Prueba1";

                String cod_colegio = "cod_colegio";
                String nombre = "nombre";
                String direccion = "direccion";

                String insert="INSERT INTO "+ tabla +" ( " +cod_colegio+","+nombre+","+direccion+")" + " VALUES ("+555+", '"+text_nombre.getText().toString()+"','" +text_nombre.getText().toString()+"')";

                if(bd.isOpen()){

                    bd.execSQL(insert);

                }

                bd.close();
            }
        });


    }
}