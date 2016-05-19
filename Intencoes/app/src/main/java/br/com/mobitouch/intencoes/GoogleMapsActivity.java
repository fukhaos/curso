package br.com.mobitouch.intencoes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class GoogleMapsActivity extends ActionBarActivity {

    private EditText endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        endereco = (EditText) findViewById(R.id.endereco);
    }

    public void irMaps(View view) {
        Uri uri = Uri.parse("geo:0,0?q=" + endereco.getText().toString().replace(" ", "+"));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
