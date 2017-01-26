package com.diostock.diostock.activity.list;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.DownloadTask;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.activity.model.Fornecedor;
import com.diostock.diostock.activity.up.UpClientActivity;

import java.util.ArrayList;

/**
 * Created by IMT 02 on 17/01/2017.
 */

public class CustomListProvider extends BaseAdapter implements ListAdapter {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    private ArrayList<Fornecedor> list = new ArrayList<Fornecedor>();
    private Context context;



    public CustomListProvider(ArrayList<Fornecedor> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return list.get(pos).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_cliente, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position).getNome());

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
        Button addBtn = (Button)view.findViewById(R.id.add_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new DownloadTask((AppCompatActivity) context,EXTRA_MESSAGE,DisplayMessageActivity.class)
                        .execute("http://104.236.57.74:8080/DIOS/fornecedor/apagar/"+position);

                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpClientActivity.class);
                intent.putExtra(UpClientActivity.EXTRA_PARCELABLE, (Parcelable) list.get(position));
                context.startActivity(intent);
                notifyDataSetChanged();
            }
        });


        return view;
    }
}