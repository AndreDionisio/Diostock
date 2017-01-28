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
import com.diostock.diostock.activity.model.Estoque;
import com.diostock.diostock.activity.model.Fornecedor;
import com.diostock.diostock.activity.model.Item;
import com.diostock.diostock.activity.model.Saida;
import com.diostock.diostock.download.UploadTask;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class UpOutputActivity extends AppCompatActivity {
    public final static String EXTRA_PARCELABLE = "com.diostock.diostock.PARCELABLE";
    Saida saida = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        this.saida = intent.getParcelableExtra(EXTRA_PARCELABLE);
        setContentView(R.layout.activity_get_output_add);

        EditText editTextCodigo = (EditText) findViewById(R.id.edit_output_code);
        editTextCodigo.setText(this.saida.getCodigo());

        EditText editTextName = (EditText) findViewById(R.id.edit_output_name);
        editTextName.setText(this.saida.getNome());

        EditText editTextDate = (EditText) findViewById(R.id.edit_output_date);
        editTextDate.setText(this.saida.getData() ==null?null:new SimpleDateFormat("dd/MM/yyyy").format(this.saida.getData()));

        EditText editTextReceipt = (EditText) findViewById(R.id.edit_output_receipt);
        editTextReceipt.setText(this.saida.getNota().toString());

        EditText editTextValue = (EditText) findViewById(R.id.edit_output_value);
        editTextValue.setText(this.saida.getUnitario().toString());

        EditText editTextQuantity = (EditText) findViewById(R.id.edit_output_quantity);
        editTextQuantity.setText(this.saida.getQuantidade().toString());

        EditText editTextStock = (EditText) findViewById(R.id.edit_output_stock);
        editTextStock.setText(this.saida.getEstoque().getId().toString());

        EditText editTextItem = (EditText) findViewById(R.id.edit_output_item);
        editTextItem.setText(this.saida.getItem().getId().toString());

        EditText editTextProvider = (EditText) findViewById(R.id.edit_output_client);
        editTextProvider.setText(this.saida.getCliente().getId().toString());

    }
    //user/criar
    public void sendOutputCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_output_code);
        String codigo = editTextCodigo.getText().toString();
        this.saida.setCodigo(codigo);

        EditText editTextName = (EditText) findViewById(R.id.edit_output_name);
        String nome = editTextName.getText().toString();
        this.saida.setNome(nome);

        EditText editTextDate = (EditText) findViewById(R.id.edit_output_date);
        String data = editTextDate.getText().toString();
        try{
            this.saida.setData(data ==null?null:new SimpleDateFormat("dd/MM/yyyy").parse(data));
        } catch(Exception exception){
            CharSequence text =exception.getMessage()+" | "+exception.getCause()+" | "+exception.getLocalizedMessage();

            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }

        EditText editTextReceipt = (EditText) findViewById(R.id.edit_output_receipt);
        String nota = editTextReceipt.getText().toString();
        this.saida.setNota(Long.parseLong(nota));

        EditText editTextValue = (EditText) findViewById(R.id.edit_output_value);
        String valor = editTextValue.getText().toString();
        this.saida.setUnitario(new BigDecimal(valor==null || valor.isEmpty()?"0":valor ));

        EditText editTextQuantity = (EditText) findViewById(R.id.edit_output_quantity);
        String quantidade = editTextQuantity.getText().toString();
        this.saida.setQuantidade(new BigDecimal(quantidade==null || quantidade.isEmpty()?"0":quantidade));

        EditText editTextStock = (EditText) findViewById(R.id.edit_output_stock);
        String estoque = editTextStock.getText().toString();
        this.saida.setEstoque(new Estoque(Long.parseLong(estoque)));

        EditText editTextItem = (EditText) findViewById(R.id.edit_output_item);
        String item = editTextItem.getText().toString();
        this.saida.setItem(new Item(Long.parseLong(item)));

        EditText editTextClient = (EditText) findViewById(R.id.edit_output_client);
        String cliente = editTextClient.getText().toString();
        this.saida.setCliente(new Cliente(Long.parseLong(cliente)));

        /*new UploadTask(this,MainActivity.EXTRA_MESSAGE,DisplayMessageActivity.class,this.saida)
              .execute("http://104.236.57.74:8080/DIOS/cliente/atualizar");*/

    }
}