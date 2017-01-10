package com.diostock.diostock.activity.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DownloadTask;
import com.diostock.diostock.R;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class AddInputActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_input_add);
    }
    //user/criar
    public void sendInputCreateMessage(View view) {
        EditText editTextData = (EditText) findViewById(R.id.edit_input_date);
        String data = editTextData.getText().toString();
        EditText editTextNota = (EditText) findViewById(R.id.edit_input_receipt);
        String nota = editTextNota.getText().toString();

        EditText editTextUnitario = (EditText) findViewById(R.id.edit_input_value);
        String unitario = editTextUnitario.getText().toString();
        EditText editTextQuantidade = (EditText) findViewById(R.id.edit_input_quantity);
        String quantidade = editTextQuantidade.getText().toString();

        EditText editTextEstoque = (EditText) findViewById(R.id.edit_input_stock);
        String estoque = editTextEstoque.getText().toString();
        EditText editTextItem = (EditText) findViewById(R.id.edit_input_item);
        String item = editTextItem.getText().toString();

        EditText editTextFornecedor = (EditText) findViewById(R.id.edit_input_provider);
        String fornecedor = editTextFornecedor.getText().toString();

        new DownloadTask(this,EXTRA_MESSAGE).execute("http://www.jmksistemas.com.br/TEST/entrada/adicionar?data="+data+"&nota="+nota
                +"&unitario="+unitario
                +"&quantidade="+quantidade
                +"&estoque="+estoque
                +"&item="+item
                +"&fornecedor="+fornecedor);

    }
}