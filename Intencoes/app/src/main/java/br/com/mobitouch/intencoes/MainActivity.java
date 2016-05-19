package br.com.mobitouch.intencoes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void callNumber(View view) {
        Intent intent = new Intent(this, LigarNumeroActivity.class);
        startActivity(intent);
    }

    public void callEmail(View view) {
        Intent intent = new Intent(this, EnviarEmailActivity.class);
        startActivity(intent);
    }

    public void callSite(View view) {
        Intent intent = new Intent(this, SiteActivity.class);
        startActivity(intent);
    }

    public void callSMS(View view) {
        Intent intent = new Intent(this, SmsActivity.class);
        startActivity(intent);
    }

    public void callMaps(View view) {
        Intent intent = new Intent(this, GoogleMapsActivity.class);
        startActivity(intent);
    }

    public void callFoto(View view) {
        Intent intent = new Intent(this, FotoActivity.class);
        startActivity(intent);
    }

    public void callCompartilhar(View view) {
        Intent intent = new Intent(this, CompartilharActivity.class);
        startActivity(intent);
    }

    public void callComunicacao(View view) {
        Intent intent = new Intent(this, ComunicacaoActivity.class);
        startActivity(intent);
    }
}
