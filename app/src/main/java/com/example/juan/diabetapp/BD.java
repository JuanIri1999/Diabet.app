package com.example.juan.diabetapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {
    //Aca creamos la tabla con sus respectivos campos
    String Tabla = "CREATE TABLE Datos (Id INTEGER PRIMARY KEY AUTOINCREMENT, Mes Text, Glucosa INTEGER, Presion INTEGER, Peso INTEGER)";

    public BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        //Aca decimos que ejecute la consulta para crear la tabla
        db.execSQL(Tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
