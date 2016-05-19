package br.com.mobitouch.intencoes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class SmsActivity extends ActionBarActivity {

    private EditText numero;
    private EditText mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        numero = (EditText) findViewById(R.id.numero);
        mensagem = (EditText) findViewById(R.id.mensagem);
    }

    public void enviarSMS(View view) {

        String to = numero.getText().toString();
        String message = mensagem.getText().toString();

        Uri smsUri = Uri.parse("tel:" + to);
        Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
        intent.putExtra("address", to);
        intent.putExtra("sms_body", message);
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);

    }
}
