package com.example.juan.diabetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorEj extends BaseAdapter {
    private static LayoutInflater inflater= null;
//Declaramos el contexto, la matriz datos, y el vector de imagenes
    Context contexto;
    String [][] datos;
    int [] datosImg;

    // Creamos el constructor
    public AdaptadorEj(Context contexto, String[][] datos, int[] datosImg) {
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = datosImg;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista= inflater.inflate(R.layout.layout_listitem2, null);
//Casting de los elementos del ListView
        TextView titulo = (TextView) vista.findViewById(R.id.tvTituloej);
        TextView duracion = (TextView) vista.findViewById(R.id.tvDescripcionEj);
        ImageView imagen= (ImageView) vista.findViewById(R.id.ivImagenEj);
    // Aca seteamos los valores de Datos mediante su posicion
        titulo.setText(datos[0][i]);
        duracion.setText("Duracion:" + datos[1][i]);
        imagen.setImageResource(datosImg[i]);

        return vista;



    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
