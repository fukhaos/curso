package br.unipar.listatarefassugar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.unipar.listatarefassugar.dados.Tarefa;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private List<Tarefa> tarefas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lista);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(listView);

        tarefas = Tarefa.listAll(Tarefa.class);


        items = new ArrayList<String>();

        for(Tarefa t: tarefas){
            items.add(t.getTexto());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);


       // Tarefa nova_tarefa = new Tarefa("Pagar a conta de luz");
       // nova_tarefa.save();


       //remover itens
        removerItens();
    }

    private void removerItens() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();

                //remove o banco
                tarefas.get(position).delete();

                return true;
            }
        });
    }


    public void addTarefa(View view){
        Log.i("Aqui", "Aqui");
        final AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Lista de Tarefas");
        alerta.setMessage("Adicione um item");

        final EditText campo = new EditText(this);
        campo.setHint("ex: estudar android");
        alerta.setView(campo);

        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String valor = campo.getText().toString();

                Tarefa nova_tarefa = new Tarefa(valor);
                nova_tarefa.save();

                items.add(valor);
                adapter.notifyDataSetChanged();
            }
        });

        alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }
        });

        alerta.show();
    }
}
