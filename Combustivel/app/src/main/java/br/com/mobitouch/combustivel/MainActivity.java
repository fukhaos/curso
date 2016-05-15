package br.com.mobitouch.combustivel;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private TextView campo_gasolina;
    private TextView campo_etanol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //#E1411B

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo_gasolina = (TextView) findViewById(R.id.campo_gasolina);
        campo_etanol = (TextView) findViewById(R.id.campo_etanol);
    }

    public void calcular(View view) {
        //Toast.makeText(this, "Vamos calcular", Toast.LENGTH_SHORT).show();


        //pega os valores dos campos
        String texto_gasolina = campo_gasolina.getText().toString();
        String texto_etanol = campo_etanol.getText().toString();



        //validacoes
        if (texto_gasolina.isEmpty()) {
            campo_gasolina.setError("Prencha a gasolina");
        } else if (texto_etanol.isEmpty()) {
            campo_etanol.setError("Prencha o etanol");
        } else {


            //converte para double
            double valor_gasolina = Double.parseDouble(texto_gasolina);
            double valor_etanol = Double.parseDouble(texto_etanol);


            //calculo
            double resultado = valor_etanol / valor_gasolina;


            //cria o alert
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Resultado");

            //resultado
            if (resultado >= 0.7) {
                alertDialog.setMessage("Abasteça com Gasolina"); //gasolina
            } else {
                alertDialog.setMessage("Abasteça com Etanol"); //etanol
            }

            alertDialog.show();
        }


    }


}
