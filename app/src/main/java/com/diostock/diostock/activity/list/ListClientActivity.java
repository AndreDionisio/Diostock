package com.diostock.diostock.activity.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.diostock.diostock.R;
import com.diostock.diostock.activity.add.AddClientActivity;
import com.diostock.diostock.activity.model.Cliente;

import java.util.ArrayList;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class ListClientActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    public final static String EXTRA_ARRAY = "com.diostock.diostock.ARRAY";
    public static ArrayList<Cliente> clienteList = new ArrayList<Cliente>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_client_list);

        Intent intent = getIntent();
        clienteList = intent.getParcelableArrayListExtra(EXTRA_ARRAY);//StringExtra(MainActivity.EXTRA_MESSAGE);


                //instantiate custom adapter
                CustomListClient adapter = new CustomListClient(clienteList, this);

                //handle listview and assign adapter
                ListView lView = (ListView)findViewById(R.id.my_listview);
                lView.setAdapter(adapter);


    }
    //user/criar
    /*public void sendClientListMessage(View view) {

        new DownloadTaskClient(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://104.236.57.74:8080/DIOS/cliente/listar");

    }*/
    public void sendClientAdd(View view) {
        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
}
