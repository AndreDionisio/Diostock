package com.diostock.diostock.activity.up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.MainActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.activity.model.Entrada;
import com.diostock.diostock.activity.model.Estoque;
import com.diostock.diostock.activity.model.Fornecedor;
import com.diostock.diostock.activity.model.Item;
import com.diostock.diostock.download.UploadTask;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class UpInputActivity extends AppCompatActivity {
    public final static String EXTRA_PARCELABLE = "com.diostock.diostock.PARCELABLE";
    Entrada entrada = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.entrada = intent.getParcelableExtra(EXTRA_PARCELABLE);
        setContentView(R.layout.activity_get_input_add);

        EditText editTextCodigo = (EditText) findViewById(R.id.edit_input_code);
        editTextCodigo.setText(this.entrada.getCodigo());

        EditText editTextName = (EditText) findViewById(R.id.edit_input_name);
        editTextName.setText(this.entrada.getNome());

        EditText editTextDate = (EditText) findViewById(R.id.edit_input_date);
        editTextDate.setText(this.entrada.getData() ==null?null:new SimpleDateFormat("dd/MM/yyyy").format(this.entrada.getData()));

        EditText editTextReceipt = (EditText) findViewById(R.id.edit_input_receipt);
        editTextReceipt.setText(this.entrada.getNota().toString());

        EditText editTextValue = (EditText) findViewById(R.id.edit_input_value);
        editTextValue.setText(this.entrada.getUnitario().toString());

        EditText editTextQuantity = (EditText) findViewById(R.id.edit_input_quantity);
        editTextQuantity.setText(this.entrada.getQuantidade().toString());

        EditText editTextStock = (EditText) findViewById(R.id.edit_input_stock);
        editTextStock.setText(this.entrada.getEstoque().getId().toString());

        EditText editTextItem = (EditText) findViewById(R.id.edit_input_item);
        editTextItem.setText(this.entrada.getItem().getId().toString());

        EditText editTextProvider = (EditText) findViewById(R.id.edit_input_provider);
        editTextProvider.setText(this.entrada.getFornecedor().getId().toString());
    }
    //user/criar
    public void sendClientCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_input_code);
        String codigo = editTextCodigo.getText().toString();
        this.entrada.setCodigo(codigo);

        EditText editTextName = (EditText) findViewById(R.id.edit_input_name);
        String nome = editTextName.getText().toString();
        this.entrada.setNome(nome);

        EditText editTextDate = (EditText) findViewById(R.id.edit_input_date);
        String data = editTextDate.getText().toString();
        try{
            this.entrada.setData(data ==null?null:new SimpleDateFormat("dd/MM/yyyy").parse(data));
        } catch(Exception exception){
            CharSequence text =exception.getMessage()+" | "+exception.getCause()+" | "+exception.getLocalizedMessage();

            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }

        EditText editTextReceipt = (EditText) findViewById(R.id.edit_input_receipt);
        String nota = editTextReceipt.getText().toString();
        this.entrada.setNota(Long.parseLong(nota));

        EditText editTextValue = (EditText) findViewById(R.id.edit_input_value);
        String valor = editTextValue.getText().toString();
        this.entrada.setUnitario(new BigDecimal(valor));

        EditText editTextQuantity = (EditText) findViewById(R.id.edit_input_quantity);
        String quantidade = editTextQuantity.getText().toString();
        this.entrada.setQuantidade(new BigDecimal(quantidade));

        EditText editTextStock = (EditText) findViewById(R.id.edit_input_stock);
        String estoque = editTextStock.getText().toString();
        this.entrada.setEstoque(new Estoque(Long.parseLong(estoque)));

        EditText editTextItem = (EditText) findViewById(R.id.edit_input_item);
        String item = editTextItem.getText().toString();
        this.entrada.setItem(new Item(Long.parseLong(item)));

        EditText editTextProvider = (EditText) findViewById(R.id.edit_input_provider);
        String fornecedor = editTextProvider.getText().toString();
        this.entrada.setFornecedor(new Fornecedor(Long.parseLong(fornecedor)));

        /*new UploadTask(this,MainActivity.EXTRA_MESSAGE,DisplayMessageActivity.class,this.entrada)
              .execute("http://104.236.57.74:8080/DIOS/cliente/atualizar");*/

    }
}