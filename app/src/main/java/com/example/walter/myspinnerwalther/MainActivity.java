package com.example.walter.myspinnerwalther;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Spinner spi;
    private TextView vt;
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.txt_nun1);
        et2 = (EditText)findViewById(R.id.txt_nun2);
        vt = (TextView)findViewById(R.id.tv_resultado);
        spi = (Spinner)findViewById(R.id.spinner);

        String [] opciones ={"seleccione...","sumar","restar","multiplicar","dividir"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.spinner_item,opciones);
        spi.setAdapter(adapter);
        spi.setSelection(0);

    }

    // metodo del boton

    public  void resul (View view){
        try {
            DecimalFormat decimal = new DecimalFormat("0.0");
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();

            int v1 = Integer.parseInt(valor1);
            int v2 = Integer.parseInt(valor2);
            String seleccion = spi.getSelectedItem().toString();
            if (seleccion.equals("sumar")){
                int suma = v1 + v2;
                String resultado = String.valueOf(suma);
                vt.setText(resultado);
                spi.setSelection(0);
            }else if (seleccion.equals("restar")){
                int suma = v1 - v2;
                String resultado = String.valueOf(suma);
                vt.setText(resultado);
                spi.setSelection(0);
            }else if (seleccion.equals("multiplicar")){
                int suma = v1 * v2;
                String resultado = String.valueOf(suma);
                vt.setText(resultado);
                spi.setSelection(0);
            }else if (seleccion.equals("dividir")){
                if (v2 != 0){
                    double v1f = Double.parseDouble(valor1);
                    double v2f = Double.parseDouble(valor2);
                    double suma = v1f / v2f;
                    String resultado = String.valueOf(suma);
                    vt.setText(resultado);
                    spi.setSelection(0);
                }else {
                    Toast.makeText(this,"no se puede dividir entre cero",Toast.LENGTH_SHORT).show();
                }

            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}

