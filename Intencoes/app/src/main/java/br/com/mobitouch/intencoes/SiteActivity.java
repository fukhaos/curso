package br.com.mobitouch.intencoes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class SiteActivity extends ActionBarActivity {

    EditText site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        site = (EditText) findViewById(R.id.site);
    }

    public void irSite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(site.getText().toString()));
        startActivity(browserIntent);
    }
}
