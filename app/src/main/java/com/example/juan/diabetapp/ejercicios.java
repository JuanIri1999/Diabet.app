package com.example.juan.diabetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ejercicios extends AppCompatActivity {
    ListView lista;

    //Declaramos otra matriz, esta vez para la seccion de ejercicios
    String[] [] datos = {
            {       "Caminar ","Natacion", "Bicicleta",
                    "Entrenamiento con pesas","Tai-chi ",
            },
            {       "90 min" ,
                    "30 min" ,
                    "30 min" ,
                    "45 min" ,
                    "1 hora" ,}

    };

    int [] datosImg= {R.drawable.ej1, R.drawable.ej2, R.drawable.ej3, R.drawable.ej4, R.drawable.ej5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        lista = (ListView) findViewById(R.id.lvLista);

        lista.setAdapter(new Adaptador(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = null;
                //Mediante la posicion, obtenemos la clase a la que queremos que nos redirija cuando un elemento del listView es presionado
                switch (position) {
                    case 0: {
                        i = new Intent(view.getContext(),Caminar.class);
                        break;
                    }

                    case 1: {
                        i = new Intent(view.getContext(),Natacion.class);
                        break;
                    }

                    case 2: {
                        i = new Intent(view.getContext(),Bicicleta.class);
                        break;
                    }

                    case 3: {
                        i = new Intent(view.getContext(),Entrenamiento.class);
                        break;
                    }

                    case 4: {
                        i = new Intent(view.getContext(),Taichi.class);
                        break;
                    }



                }
                startActivity(i);
            }
        });
    }

}
