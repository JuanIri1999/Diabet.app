package com.example.juan.diabetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater= null;
// Declaramos el contexto, la matriz Datos y el vector de imagenes
    Context contexto;
    String [][] datos;
    int [] datosImg;

    //Creamos el constructor del Adaptador
    public Adaptador(Context contexto, String[][] datos, int[] datosImg) {


        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = datosImg;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
}



    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
       //Inflamos el Layout
        final View vista= inflater.inflate(R.layout.layout_listitem, null);

        //Realizamos el casting de los elementos del ListView
        TextView titulo = (TextView) vista.findViewById(R.id.tvTitulo);
        TextView descripcion = (TextView) vista.findViewById(R.id.tvDescripcion);
        ImageView imagen= (ImageView) vista.findViewById(R.id.ivImagen);
    //Seteamos los valores de datos segun su posicion
        titulo.setText(datos[0][i]);
        descripcion.setText(datos[1][i]);
        imagen.setImageResource(datosImg[i]);


        return vista;



    }

    @Override
    public int getCount() {
        //Retornamos el ancho de las imagenes
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
