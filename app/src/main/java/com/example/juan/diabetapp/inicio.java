package com.example.juan.diabetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class inicio extends AppCompatActivity implements View.OnClickListener{

    //Declaramos los CardView
    CardView nuevoregistro, consultar, alimentos, ejercicios, calculadora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Casteamos los CardView
        nuevoregistro=(CardView) findViewById(R.id.card_nuevoreg);
        consultar=(CardView) findViewById(R.id.card_consultar);
        alimentos=(CardView) findViewById(R.id.card_alimentos);
        ejercicios=(CardView) findViewById(R.id.card_ejercicios);
        calculadora=(CardView) findViewById(R.id.card_calc);

        // Implementamos el metodo onClickListener a cada uno de los elementos del CardView
        nuevoregistro.setOnClickListener(this);
        consultar.setOnClickListener(this);
        alimentos.setOnClickListener(this);
        ejercicios.setOnClickListener(this);
        calculadora.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            //Aca mediante un Switch mediante el id de los cardView, obtenemos la posicion de su elemento, y de ahi, iniciara una actividad
            // por medio del metodo onClick
            case R.id.card_nuevoreg: i = new Intent(this,registro.class);     startActivity(i);break;
            case R.id.card_consultar: i = new Intent(this,consultar.class);   startActivity(i);break;
            case R.id.card_alimentos: i = new Intent(this,alimentos.class);   startActivity(i);break;
            case R.id.card_ejercicios: i = new Intent(this,ejercicios.class); startActivity(i);break;
            case R.id.card_calc: i = new Intent(this,calculadora.class);      startActivity(i); break;
            default: break;
        }
    }
}
