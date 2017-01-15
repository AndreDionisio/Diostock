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
public class AddUnitActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_unit_add);
    }
    //user/criar
    public void sendUnitCreateMessage(View view) {
        EditText editTextUnidade = (EditText) findViewById(R.id.edit_unit_unit);
        String unidade = editTextUnidade.getText().toString();
        EditText editTextDescricao = (EditText) findViewById(R.id.edit_unit_description);
        String descricao = editTextDescricao.getText().toString();
        new DownloadTask(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://www.jmksistemas.com.br/TEST/unidade/adicionar?unidade="+unidade+"&descricao="+descricao);

    }
}