package com.diostock.diostock.activity.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.add.AddClientActivity;
import com.diostock.diostock.activity.add.AddItemActivity;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.activity.model.Item;
import com.diostock.diostock.download.DownloadTaskCliente;

import java.util.ArrayList;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class ListItemActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    public final static String EXTRA_ARRAY = "com.diostock.diostock.ARRAY";
    public static ArrayList<Item> itemList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_client_list);

        Intent intent = getIntent();
        itemList = intent.getParcelableArrayListExtra(EXTRA_ARRAY);//StringExtra(MainActivity.EXTRA_MESSAGE);

        //instantiate custom adapter
        CustomListItem adapter = new CustomListItem(itemList, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.my_listview);
        lView.setAdapter(adapter);
    }

    public void sendClientAdd(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }
}
