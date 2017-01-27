package com.diostock.diostock.activity.up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.MainActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.download.UploadTask;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class UpOutputActivity extends AppCompatActivity {
    public final static String EXTRA_PARCELABLE = "com.diostock.diostock.PARCELABLE";
    Cliente cliente = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.cliente = intent.getParcelableExtra(EXTRA_PARCELABLE);
        setContentView(R.layout.activity_get_client_add);
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_client_code);
        editTextCodigo.setText(this.cliente.getCodigo());
        EditText editTextName = (EditText) findViewById(R.id.edit_client_name);
        editTextName.setText(this.cliente.getNome());

    }
    //user/criar
    public void sendClientCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_client_code);
        String codigo = editTextCodigo.getText().toString();
        this.cliente.setCodigo(codigo);
        EditText editTextName = (EditText) findViewById(R.id.edit_client_name);
        String nome = editTextName.getText().toString();
        this.cliente.setNome(nome);
        new UploadTask(this,MainActivity.EXTRA_MESSAGE,DisplayMessageActivity.class,this.cliente)
                .execute("http://104.236.57.74:8080/DIOS/cliente/atualizar");

    }
}