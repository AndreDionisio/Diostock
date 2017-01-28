package com.diostock.diostock.activity.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.diostock.diostock.R;
import com.diostock.diostock.activity.add.AddClientActivity;
import com.diostock.diostock.activity.model.Estoque;

import java.util.ArrayList;

/**
 * Created by IMT 02 on 08/01/2017.
 */

public class ListStockActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    public final static String EXTRA_ARRAY = "com.diostock.diostock.ARRAY";
    public static ArrayList<Estoque> estoqueList = new ArrayList<Estoque>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_client_list);

        Intent intent = getIntent();
        estoqueList = intent.getParcelableArrayListExtra(EXTRA_ARRAY);//StringExtra(MainActivity.EXTRA_MESSAGE);

        //instantiate custom adapter
        CustomListStock adapter = new CustomListStock(estoqueList, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.my_listview);
        lView.setAdapter(adapter);
    }

    public void sendClientAdd(View view) {
        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
}
