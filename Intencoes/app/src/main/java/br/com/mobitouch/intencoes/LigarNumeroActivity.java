package br.com.mobitouch.intencoes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class LigarNumeroActivity extends ActionBarActivity {

    private EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligar_numero);

        numero = (EditText) findViewById(R.id.numero);
    }

    public void ligar(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + numero.getText().toString()));
        startActivity(callIntent);
    }
}
