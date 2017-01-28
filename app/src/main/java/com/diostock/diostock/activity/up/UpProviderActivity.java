package com.diostock.diostock.activity.up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.MainActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Fornecedor;
import com.diostock.diostock.upload.UploadTaskProvider;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class UpProviderActivity extends AppCompatActivity {
    public final static String EXTRA_PARCELABLE = "com.diostock.diostock.PARCELABLE";
    Fornecedor fornecedor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.fornecedor = intent.getParcelableExtra(EXTRA_PARCELABLE);
        setContentView(R.layout.activity_get_provider_add);
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_provider_code);
        editTextCodigo.setText(this.fornecedor.getCodigo());
        EditText editTextName = (EditText) findViewById(R.id.edit_provider_name);
        editTextName.setText(this.fornecedor.getNome());

    }
    //user/criar
    public void sendProviderCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_provider_code);
        String codigo = editTextCodigo.getText().toString();
        this.fornecedor.setCodigo(codigo);
        EditText editTextName = (EditText) findViewById(R.id.edit_provider_name);
        String nome = editTextName.getText().toString();
        this.fornecedor.setNome(nome);
        new UploadTaskProvider(this, MainActivity.EXTRA_MESSAGE,DisplayMessageActivity.class,this.fornecedor)
                .execute("http://104.236.57.74:8080/DIOS/fornecedor/atualizar");

    }
}