package com.diostock.diostock.activity.list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.JsonToken;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.DownloadTask;
import com.diostock.diostock.MainActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.add.AddClientActivity;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.download.DownloadTaskCliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class ListClientActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    public final static String EXTRA_ARRAY = "com.diostock.diostock.ARRAY";
    public static ArrayList<Cliente> clienteList = new ArrayList<Cliente>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_client_list);

        Intent intent = getIntent();
        clienteList = intent.getParcelableArrayListExtra(EXTRA_ARRAY);//StringExtra(MainActivity.EXTRA_MESSAGE);


                //instantiate custom adapter
                CustomListClient adapter = new CustomListClient(clienteList, this);

                //handle listview and assign adapter
                ListView lView = (ListView)findViewById(R.id.my_listview);
                lView.setAdapter(adapter);

        /*
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_client);
        for(Cliente cliente:clienteList) {
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText("------------------------------");
//http://stackoverflow.com/questions/17525886/listview-with-add-and-delete-buttons-in-each-row-in-android
            layout.addView(textView);

            TextView textViewId = new TextView(this);
            textViewId.setTextSize(40);
            textViewId.setText(Long.toString(cliente.getId()));

            layout.addView(textViewId);

            TextView textViewCodigo = new TextView(this);
            textViewCodigo.setTextSize(40);
            textViewCodigo.setText(cliente.getCodigo());

            layout.addView(textViewCodigo);

            TextView textViewCliente = new TextView(this);
            textViewCliente.setTextSize(40);
            textViewCliente.setText(cliente.getNome());

            layout.addView(textViewCliente);
        }*/
    }
    //user/criar
    public void sendClientListMessage(View view) {

        new DownloadTaskCliente(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://www.jmksistemas.com.br/TEST/cliente/listar");

    }
    public void sendClientAdd(View view) {
        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
}