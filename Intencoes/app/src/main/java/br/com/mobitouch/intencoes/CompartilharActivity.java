package br.com.mobitouch.intencoes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class CompartilharActivity extends ActionBarActivity {

    EditText mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartilhar);

        mensagem = (EditText) findViewById(R.id.mensagem);
    }

    public void compartilhar(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/html");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mensagem.getText().toString());
        startActivity(Intent.createChooser(sharingIntent,"Compartilhar usando:"));
    }
}
