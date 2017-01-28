package com.diostock.diostock.activity.up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Unidade;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class UpUnitActivity extends AppCompatActivity {
    public final static String EXTRA_PARCELABLE = "com.diostock.diostock.PARCELABLE";
    Unidade unidade = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.unidade = intent.getParcelableExtra(EXTRA_PARCELABLE);
        setContentView(R.layout.activity_get_unit_add);
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_unit_description);
        editTextCodigo.setText(this.unidade.getDescricao());
        EditText editTextName = (EditText) findViewById(R.id.edit_unit_unit);
        editTextName.setText(this.unidade.getUnidade());

    }
    //user/criar
    public void sendunitCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_unit_description);
        String codigo = editTextCodigo.getText().toString();
        this.unidade.setDescricao(codigo);
        EditText editTextName = (EditText) findViewById(R.id.edit_unit_unit);
        String nome = editTextName.getText().toString();
        this.unidade.setUnidade(nome);
        /*new UploadTask(this,MainActivity.EXTRA_MESSAGE,DisplayMessageActivity.class,this.unidade)
                .execute("http://104.236.57.74:8080/DIOS/unite/atualizar");*/

    }
}