package com.diostock.diostock.activity.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.download.DownloadTask;
import com.diostock.diostock.R;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class AddStockActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_stock_add);
    }
    //user/criar
    public void sendStockCreateMessage(View view) {
        EditText editTextLocal = (EditText) findViewById(R.id.edit_stock_local);
        String local = editTextLocal.getText().toString();
        EditText editTextCorredor = (EditText) findViewById(R.id.edit_stock_hall);
        String corredor = editTextCorredor.getText().toString();
        EditText editTextPrateleira = (EditText) findViewById(R.id.edit_stock_shelf);
        String prateleira = editTextPrateleira.getText().toString();
        EditText editTextAndar = (EditText) findViewById(R.id.edit_stock_floor);
        String andar = editTextAndar.getText().toString();
        EditText editTextBox = (EditText) findViewById(R.id.edit_stock_box);
        String box = editTextBox.getText().toString();
        EditText editTextUnidade = (EditText) findViewById(R.id.edit_stock_unit);
        String unidade = editTextUnidade.getText().toString();
        EditText editTextSaldo = (EditText) findViewById(R.id.edit_stock_balance);
        String saldo = editTextSaldo.getText().toString();

        new DownloadTask(this,EXTRA_MESSAGE,DisplayMessageActivity.class)
                .execute("http://104.236.57.74:8080/DIOS/estoque/criar?local="+local
                        +"&corredor="+corredor
                        +"&prateleira="+prateleira
                        +"&andar="+andar
                        +"&box="+box
                        +"&unidade="+unidade
                        +"&saldo="+saldo
                );

    }
}