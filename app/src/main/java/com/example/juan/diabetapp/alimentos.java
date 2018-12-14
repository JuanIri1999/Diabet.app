package com.example.juan.diabetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class alimentos extends AppCompatActivity {
    ListView lista;
//Declaramos una matriz Datos, donde cada valor de la matriz va acompañado de un texto
    String[] [] datos = {
            {       "Manzana con helado ","Tarta de Manzanas", "Revuelto light de" +
                    " zapallitos","Albondigas light ", "Sorrentinos light"
                   },
            {       "Pulse aqui para ver como se prepara" ,
                    "Pulse aqui para ver como se prepara" ,
                    "Pulse aqui para ver como se prepara" ,
                    "Pulse aqui para ver como se prepara" ,
                    "Pulse aqui para ver como se prepara" ,}

    };
    //Declaramos un vector de imagenes, que se usara para rellenar el ListView
    int [] datosImg= {R.drawable.comida1, R.drawable.comida2, R.drawable.comida3, R.drawable.comida4, R.drawable.comida5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);

        lista = (ListView) findViewById(R.id.lvLista);
        lista.setAdapter(new Adaptador(this,datos,datosImg));

        //Aca implementamos el SetOnItemClickListener
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = null;
                //Aca vamos a decir que si un elemento es pulsado, mediante su posicion nos diriga a su clase.
                switch (position) {
                    case 0:
                    {
                        i = new Intent(view.getContext(),Manzana.class);
                        break;
                    }
                    case 1:
                    {
                        i = new Intent(view.getContext(),tarta.class);
                        break;
                    }
                    case 2:
                    {
                        i = new Intent(view.getContext(),revuelto.class);
                        break;
                    }
                    case 3:
                    {
                        i = new Intent(view.getContext(),Albondigas.class);
                        break;
                    }
                    case 4:
                    {
                        i = new Intent(view.getContext(),Sorrentinos.class);
                        break;
                    }


                }
                startActivity(i);
            }
        });
    }


    }

