package com.diostock.diostock.activity.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.DownloadTask;
import com.diostock.diostock.R;

/**
 * Created by IMT 02 on 08/01/2017.
 */

import android.support.v7.app.AppCompatActivity;
public class AddOutputActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_output_add);
    }
    //user/criar
    public void sendOutputCreateMessage(View view) {
        EditText editTextData = (EditText) findViewById(R.id.edit_output_date);
        String data = editTextData.getText().toString();
        EditText editTextNota = (EditText) findViewById(R.id.edit_output_receipt);
        String nota = editTextNota.getText().toString();

        EditText editTextUnitario = (EditText) findViewById(R.id.edit_output_value);
        String unitario = editTextUnitario.getText().toString();
        EditText editTextQuantidade = (EditText) findViewById(R.id.edit_output_quantity);
        String quantidade = editTextQuantidade.getText().toString();

        EditText editTextEstoque = (EditText) findViewById(R.id.edit_output_stock);
        String estoque = editTextEstoque.getText().toString();
        EditText editTextItem = (EditText) findViewById(R.id.edit_output_item);
        String item = editTextItem.getText().toString();

        EditText editTextCliente = (EditText) findViewById(R.id.edit_output_client);
        String cliente = editTextCliente.getText().toString();

        new DownloadTask(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://www.jmksistemas.com.br/TEST/saida/adicionar?data="+data+"&nota="+nota
                +"&unitario="+unitario
                +"&quantidade="+quantidade
                +"&estoque="+estoque
                +"&item="+item
                +"&cliente="+cliente);

    }
}