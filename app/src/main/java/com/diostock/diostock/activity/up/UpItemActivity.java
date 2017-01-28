package com.diostock.diostock.activity.up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Estoque;
import com.diostock.diostock.activity.model.Item;
import com.diostock.diostock.activity.model.Unidade;

import java.math.BigDecimal;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class UpItemActivity extends AppCompatActivity {
    public final static String EXTRA_PARCELABLE = "com.diostock.diostock.PARCELABLE";
    Item item = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.item = intent.getParcelableExtra(EXTRA_PARCELABLE);
        setContentView(R.layout.activity_get_item_add);

        EditText editTextCodigo = (EditText) findViewById(R.id.edit_item_code);
        editTextCodigo.setText(this.item.getCodigo());

        EditText editTextName = (EditText) findViewById(R.id.edit_item_name);
        editTextName.setText(this.item.getNome());

        EditText editTextDescription = (EditText) findViewById(R.id.edit_item_description);
        editTextDescription.setText(this.item.getDescricao());

        EditText editTextUnit = (EditText) findViewById(R.id.edit_item_unit);
        editTextUnit.setText(this.item.getUnidade().getId().toString());

        EditText editTextBalance = (EditText) findViewById(R.id.edit_item_balance);
        editTextBalance.setText(this.item.getSaldo().toString());

        EditText editTextStock = (EditText) findViewById(R.id.edit_item_stock);
        editTextStock.setText(this.item.getEstoque().getId().toString());
    }
    //user/criar
    public void sendItemCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_item_code);
        String codigo = editTextCodigo.getText().toString();
        this.item.setCodigo(codigo);

        EditText editTextName = (EditText) findViewById(R.id.edit_item_name);
        String nome = editTextName.getText().toString();
        this.item.setNome(nome);

        EditText editTextDescription = (EditText) findViewById(R.id.edit_item_description);
        String descricao = editTextDescription.getText().toString();
        this.item.setDescricao(descricao);

        EditText editTextUnit = (EditText) findViewById(R.id.edit_item_unit);
        String unidade = editTextUnit.getText().toString();
        this.item.setUnidade(new Unidade(Long.parseLong(unidade)));

        EditText editTextBalance = (EditText) findViewById(R.id.edit_item_balance);
        String saldo = editTextBalance.getText().toString();
        this.item.setSaldo(new BigDecimal(saldo==null || saldo.isEmpty()?"0":saldo));

        EditText editTextStock = (EditText) findViewById(R.id.edit_item_stock);
        String estoque = editTextStock.getText().toString();
        this.item.setEstoque(new Estoque(Long.parseLong(estoque)));

        /*new UploadTask(this,MainActivity.EXTRA_MESSAGE,DisplayMessageActivity.class,this.item)
                .execute("http://104.236.57.74:8080/DIOS/item/atualizar");*/

    }
}