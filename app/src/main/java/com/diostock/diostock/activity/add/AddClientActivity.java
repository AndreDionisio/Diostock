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

public class AddClientActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_client_add);
    }
    //user/criar
    public void sendClientCreateMessage(View view) {
        EditText editTextCodigo = (EditText) findViewById(R.id.edit_client_code);
        String codigo = editTextCodigo.getText().toString();
        EditText editTextName = (EditText) findViewById(R.id.edit_client_name);
        String nome = editTextName.getText().toString();
        new DownloadTask(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://104.236.57.74:8080/DIOS/cliente/criar?codigo="+codigo+"&nome="+nome);

    }
}