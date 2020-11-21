package com.cescristorey.recyclerview.ejemplorecyclerview;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BaseDeDatos sqlile;
    ArrayList<Colegio> datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Colegio>();

        /*datos.add(new Colegio(123 , ""  + "Cristo Rey" ,  "Murcia"));
        datos.add(new Colegio(456 , ""  + "Rodriguez Delgado" ,  "Malaga"));
        datos.add(new Colegio(789 , ""  + "Perez Guzman" ,  "Granada"));
        datos.add(new Colegio(753 , ""  + "Miguel Cervantes" ,  "Barcelona"));
        datos.add(new Colegio(159, ""  + "Juan Carrillo" ,  "Madrid"));*/

        sqlile = new BaseDeDatos(this, "baseDatos", null, 1);

        SQLiteDatabase bd = sqlile.getWritableDatabase();

        if(bd.isOpen()){
            bd.execSQL("DELETE FROM Colegio");
            bd.execSQL("INSERT INTO Colegio (cod_colegio, nombre, direccion) VALUES (42, 'Cristo Rey', 'Calle Murcia')");
            bd.execSQL("INSERT INTO Colegio (cod_colegio, nombre, direccion) VALUES (43, 'Rodriguez Delgado', 'Calle Brasil')");
            bd.execSQL("INSERT INTO Colegio (cod_colegio, nombre, direccion) VALUES (44, 'Perez Guzman', 'Calle Tenorio')");
            bd.execSQL("INSERT INTO Colegio (cod_colegio, nombre, direccion) VALUES (45, 'Gonzalo Martinez', 'Calle Brasil')");
            bd.execSQL("INSERT INTO Colegio (cod_colegio, nombre, direccion) VALUES (46, 'Juan Carrillo', 'Calle America')");
            bd.execSQL("INSERT INTO Colegio (cod_colegio, nombre, direccion) VALUES (47, 'Ave María', 'Calle Venezuela')");
            bd.execSQL("INSERT INTO Colegio (cod_colegio, nombre, direccion) VALUES (48, 'Carrero Blanco', 'Calle Brasil')");

            /*ContentValues registro = new ContentValues();
            registro.put("cod_colegio", 123);
            registro.put("nombre", "nombre de ");
            registro.put("direccion", "direccion de");

            bd.insert("baseDatos", null, registro);*/
            String[] campos = new String[]{"cod_colegio", "nombre", "direccion"};
            Cursor cur = bd.query("Colegio", campos, "", null, null, null, null);

            if(cur.moveToFirst()){
                datos.clear();
                do{
                    Colegio colegio = new Colegio(0, "", "");
                    colegio.setCod_colegio((cur.getInt(0)));
                    colegio.setNombre(cur.getString(1));
                    colegio.setDireccion(cur.getString(2));
                    datos.add(colegio);

                }while(cur.moveToNext());
            }
        }

        bd.close();

        Button boton_introducir = findViewById(R.id.buttonIntroducirColegio);

        boton_introducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_introducir = new Intent(getApplicationContext(), IntroducirColegioActivity.class);
                startActivity(intent_introducir);

                SQLiteDatabase bd = sqlile.getWritableDatabase();

                String[] campos = new String[]{"cod_colegio", "nombre", "direccion"};
                Cursor cur = bd.query("Colegio", campos, "", null, null, null, null);

                if(cur.moveToFirst()){
                    datos.clear();
                    do{
                        Colegio colegio = new Colegio(0, "", "");
                        colegio.setCod_colegio((cur.getInt(0)));
                        colegio.setNombre(cur.getString(1));
                        colegio.setDireccion(cur.getString(2));
                        datos.add(colegio);

                    }while(cur.moveToNext());
                }

            }
        });


        //Inicialización RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.RecView);
        recyclerView.setHasFixedSize(false);

        //Crea el adaptador, pasándole como parámetro los datos
        final ColegioAdapter adaptador = new ColegioAdapter(datos, new ColegioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Colegio item) {
                Toast.makeText(MainActivity.this, "Equipo pulsado: ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ActividadColegio.class);

                int cod_colegio = item.getCod_colegio();
                String nombre = item.getNombre().toString();
                String direccion = item.getDireccion().toString();
                

                intent.putExtra("cod_colegio", cod_colegio);
                intent.putExtra("nombre", nombre);
                intent.putExtra("direccion", direccion);
                startActivity(intent);
            }
        });

        //Asocia a recylerView el adaptador
        recyclerView.setAdapter(adaptador);

        //Fija un layout linear al recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
