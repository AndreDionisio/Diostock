package com.diostock.diostock.activity.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DownloadTask;
import com.diostock.diostock.R;

/**
 * Created by IMT 02 on 06/01/2017.
 */

public class AddProviderActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_provider_add);
    }
    //user/criar
    public void sendProviderCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_provider_code);
        String codigo = editTextCodigo.getText().toString();
        EditText editTextName = (EditText) findViewById(R.id.edit_provider_name);
        String nome = editTextName.getText().toString();

        new DownloadTask(this,EXTRA_MESSAGE).execute("http://www.jmksistemas.com.br/TEST/fornecedor/adicionar?codigo="+codigo+"&nome="+nome);

    }
}
