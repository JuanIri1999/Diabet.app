package com.example.juan.diabetapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class consultar extends AppCompatActivity {
   //Casteamos el ListView
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        Cargar();



    }
    //Metodo con el que se genera la consulta de registros
    public void Cargar() {
        BD bd = new BD(this, "DiabetApp", null, 1);
        // Aca declaramos que la base de datos se pueda leer
        SQLiteDatabase db = bd.getReadableDatabase();
        if (db != null) {
            //Aca en la consulta "Select* from datos" decimos que nos traiga toda la información
            Cursor c = db.rawQuery("Select * from Datos", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getInt(0) + "           " + c.getString(1) + "         " + c.getInt(2) + "        " + c.getInt(3) + "        " + c.getInt(4);
                    arreglo[i] = linea;
                    i++;
                } while (c.moveToNext());
            }

            // Aca creamos un array adapter y le decimos que utilice el contexto y que use como layout principal "Lista"
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
            lista = (ListView) findViewById(R.id.lista);
            lista.setAdapter(adapter);
        }




    }
}