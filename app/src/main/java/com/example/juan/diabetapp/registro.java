
package com.example.juan.diabetapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    //Declaramos los EditTexts y el Boton
    EditText mes, glucosa, presion, peso;
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Casteamos los EditTexts
        mes = (EditText) findViewById(R.id.edtmes);
        glucosa = (EditText) findViewById(R.id.edtglucosa);
        presion = (EditText) findViewById(R.id.edtpresion);
        peso = (EditText) findViewById(R.id.edtpeso);
        guardar = (Button) findViewById(R.id.btn_guardar);
        guardar.setEnabled(false);

        mes.addTextChangedListener(validacion);
        glucosa.addTextChangedListener(validacion);
        presion.addTextChangedListener(validacion);
        peso.addTextChangedListener(validacion);
    }
         //Creamos un TextWatcher de modo que no haya que generar el mismo metodo para cada editText
         private TextWatcher validacion = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        // Mediante este metodo chequearemos que los EditTexts no esten vacios
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                String meses2= mes.getText().toString().trim();
                String glucosa2= glucosa.getText().toString().trim();
                String presion2= peso.getText().toString().trim();
                String peso2=peso.getText().toString().trim();
                //Aca decimos que si los EditTexts estan vacios, el boton de guardado no funcionara hasta que se llenen los EditTexts
                guardar.setEnabled(!meses2.isEmpty() && !glucosa2.isEmpty()&& !presion2.isEmpty() && !peso2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    //Metodo para guardar los datos, en el que se obtienen lo que el usuario ingreso en los EditTexts
    public void GuardarDatos(View view) {

        //Declaramos los campos a guardar en la base de datos
        String meses= mes.getText().toString();
        //Parseamos los INT a String
        int glucosa1= Integer.parseInt(glucosa.getText().toString());
        int presion1 = Integer.parseInt(presion.getText().toString());
        int peso1 = Integer.parseInt(peso.getText().toString());


        //Creamos un nuevo elemento BD y decimos que se pueda escribir en la base de datos
            BD bd = new BD(this, "DiabetApp", null, 1);
            SQLiteDatabase db = bd.getWritableDatabase();
            if (db != null) {
                //Aca creamos un ContentValues donde se guardaran los datos ingresados
                ContentValues registronuevo = new ContentValues();
                registronuevo.put("Mes", meses);
                registronuevo.put("Glucosa", glucosa1);
                registronuevo.put("Presion", presion1);
                registronuevo.put("Peso", peso1);
                //Aca insertamos los datos utilizando "registronuevo" Que es elemento del ContentValues que creamos
                long i = db.insert("Datos", null, registronuevo);
                if (i > 0) {
                    //Si los datos son ingresados correctamente, se muestra el mensaje del toast
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

