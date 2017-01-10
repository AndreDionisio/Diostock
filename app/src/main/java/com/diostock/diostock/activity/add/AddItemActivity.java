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
        EditText editTextDescricao = (EditText) findViewById(R.id.edit_item_description);
        String descricao = editTextDescricao.getText().toString();
        EditText editTextSaldo = (EditText) findViewById(R.id.edit_item_balance);
        String saldo = editTextSaldo.getText().toString();
        EditText editTextUnidade = (EditText) findViewById(R.id.edit_item_unit);
        String unidade = editTextUnidade.getText().toString();
        EditText editTextEstoque = (EditText) findViewById(R.id.edit_item_stock);
        String estoque = editTextEstoque.getText().toString();


        new DownloadTask(this,EXTRA_MESSAGE).execute("http://www.jmksistemas.com.br/TEST/item/adicionar?codigo="+codigo+"&descricao="+descricao
                +"&saldo="+saldo
                +"&unidade="+unidade
                +"&estoque="+estoque);

    }
}