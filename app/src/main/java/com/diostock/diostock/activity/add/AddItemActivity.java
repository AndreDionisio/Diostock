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

public class AddItemActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_item_add);
    }
    //user/criar
    public void sendItemCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_item_code);
        String codigo = editTextCodigo.getText().toString();
        EditText editTextName = (EditText) findViewById(R.id.edit_client_name);
        String nome = editTextName.getText().toString();
        EditText editTextDescricao = (EditText) findViewById(R.id.edit_item_description);
        String descricao = editTextDescricao.getText().toString();
        EditText editTextSaldo = (EditText) findViewById(R.id.edit_item_balance);
        String saldo = editTextSaldo.getText().toString();
        EditText editTextUnidade = (EditText) findViewById(R.id.edit_item_unit);
        String unidade = editTextUnidade.getText().toString();
        EditText editTextEstoque = (EditText) findViewById(R.id.edit_item_stock);
        String estoque = editTextEstoque.getText().toString();


        new DownloadTask(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://104.236.57.74:8080/DIOS/item/criar?codigo="+codigo+"&nome="+nome+"&descricao="+descricao
                +"&saldo="+saldo
                +"&unidade="+unidade
                +"&estoque="+estoque);

    }
}