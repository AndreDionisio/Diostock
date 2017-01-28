package com.diostock.diostock.activity.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.download.DownloadTask;
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
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_input_code);
        String codigo = editTextCodigo.getText().toString();
        EditText editTextName = (EditText) findViewById(R.id.edit_input_name);
        String nome = editTextName.getText().toString();

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

        new DownloadTask(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://104.236.57.74:8080/DIOS/entrada/criar?codigo="+codigo+"&nome="+nome+"&data="+data+"&nota="+nota
                +"&unitario="+unitario
                +"&quantidade="+quantidade
                +"&estoque="+estoque
                +"&item="+item
                +"&fornecedor="+fornecedor);

    }
}