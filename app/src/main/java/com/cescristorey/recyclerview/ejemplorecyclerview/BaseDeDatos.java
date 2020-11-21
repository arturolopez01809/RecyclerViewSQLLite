package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {

    public BaseDeDatos(@Nullable Context contexto, @Nullable String nombre, @Nullable SQLiteDatabase.CursorFactory factory,  int version){
        super(contexto, nombre, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Colegio (cod_colegio String, nombre String, direccion String)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAnterior, int versionNueva) {
        //Se elimina la versión anterior de la tabla
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Colegio");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL("CREATE TABLE Colegio (cod_colegio String, nombre String, direccion String)");
    }
}
