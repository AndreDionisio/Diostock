package com.diostock.diostock.activity.up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.MainActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Unidade;
import com.diostock.diostock.activity.model.Estoque;
import com.diostock.diostock.download.UploadTask;

import java.math.BigDecimal;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class UpStockActivity extends AppCompatActivity {
    public final static String EXTRA_PARCELABLE = "com.diostock.diostock.PARCELABLE";
    Estoque estoque = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.estoque = intent.getParcelableExtra(EXTRA_PARCELABLE);
        setContentView(R.layout.activity_get_stock_add);

        EditText editTextName = (EditText) findViewById(R.id.edit_stock_name);
        editTextName.setText(this.estoque.getNome());

        EditText editTextLocal = (EditText) findViewById(R.id.edit_stock_local);
        editTextLocal.setText(this.estoque.getLocal());

        EditText editTextHall = (EditText) findViewById(R.id.edit_stock_hall);
        editTextHall.setText(this.estoque.getCorredor());

        EditText editTextShelf = (EditText) findViewById(R.id.edit_stock_shelf);
        editTextShelf.setText(this.estoque.getPrateleira());

        EditText editTextFloor = (EditText) findViewById(R.id.edit_stock_floor);
        editTextFloor.setText(this.estoque.getAndar());

        EditText editTextBox = (EditText) findViewById(R.id.edit_stock_box);
        editTextBox.setText(this.estoque.getBox());

        EditText editTextUnit = (EditText) findViewById(R.id.edit_stock_unit);
        editTextUnit.setText(this.estoque.getUnidade().getId().toString());

        EditText editTextBalance = (EditText) findViewById(R.id.edit_stock_balance);
        editTextBalance.setText(this.estoque.getSaldo().toString());

    }
    //user/criar
    public void sendstockCreateMessage(View view) {

        EditText editTextName = (EditText) findViewById(R.id.edit_stock_name);
        String nome = editTextName.getText().toString();
        this.estoque.setNome(nome);

        EditText editTextLocal = (EditText) findViewById(R.id.edit_stock_local);
        String local = editTextLocal.getText().toString();
        this.estoque.setLocal(local);

        EditText editTextHall = (EditText) findViewById(R.id.edit_stock_hall);
        String hall = editTextHall.getText().toString();
        this.estoque.setCorredor(hall);

        EditText editTextShelf = (EditText) findViewById(R.id.edit_stock_shelf);
        String shelf = editTextShelf.getText().toString();
        this.estoque.setPrateleira(shelf);

        EditText editTextFloor = (EditText) findViewById(R.id.edit_stock_floor);
        String floor = editTextFloor.getText().toString();
        this.estoque.setAndar(floor);

        EditText editTextBox = (EditText) findViewById(R.id.edit_stock_box);
        String box = editTextBox.getText().toString();
        this.estoque.setBox(box);

        EditText editTextUnit = (EditText) findViewById(R.id.edit_stock_unit);
        String unit = editTextUnit.getText().toString();
        this.estoque.setUnidade(new Unidade(Long.parseLong(unit)));

        EditText editTextBalance = (EditText) findViewById(R.id.edit_stock_balance);
        String balance = editTextBalance.getText().toString();
        this.estoque.setSaldo(new BigDecimal(balance==null || balance.isEmpty()?"0":balance));
        /*new UploadTask(this,MainActivity.EXTRA_MESSAGE,DisplayMessageActivity.class,this.estoque)
                .execute("http://104.236.57.74:8080/DIOS/estoque/atualizar");*/

    }
}