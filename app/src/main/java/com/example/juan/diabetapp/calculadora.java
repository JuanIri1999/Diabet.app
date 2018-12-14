package com.example.juan.diabetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class calculadora extends AppCompatActivity {
    //Declaramos el Spinner y el TextView
    Spinner sp;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        // Aca casteamos los elementos
        sp= (Spinner) findViewById(R.id.spinner1);
        tv= (TextView) findViewById(R.id.txt1);

    //Aca declaramos un vector con el contenido de los alimentos
    String alimentos [] = { "Seleccione", "Arroz(plato mediano)", "Pan de Centeno(Unidad)", "Naranja (Unidad)"," Fideos(Plato mediano)", "Tomate(Unidad mediana)", "Leche D/C(Vaso)", "Yogurt(Unidad)", "Acelga(Porcion mediana)", "Batata(unidad)", "Avena(Porcion mediana)"
    };

    //Creamos un ArrayAdapter para el Spinner
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,alimentos);
        sp.setAdapter(adapter);

      sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              switch (position) {
             //Aca mediante la posición de los elementos del vector seteamos el texto, en esta ocasión el I.G de los alimentos
                  case 1: {
                        tv.setText(" 70");
                        break;
                  }
                  case 2: {
                      tv.setText("65");
                        break;
                  }
                  case 3: {
                      tv.setText("35");
                      break;
                  }
                  case 4: {
                      tv.setText("50");
                      break;
                  }
                  case 5: {
                      tv.setText("30");
                      break;
                  }
                  case 6: {
                      tv.setText("32");
                      break;
                  }
                  case 7: {
                      tv.setText("35");
                      break;
                  }
                  case 8: {
                      tv.setText("15");
                      break;
                  }

                  case 9: {
                      tv.setText("40");
                      break;
                  }

                  case 10: {
                      tv.setText("40");
                      break;
                  }
              }

          }
          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });



}
}