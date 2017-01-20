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
import com.diostock.diostock.MainActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.add.AddUserActivity;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.activity.up.UpClientActivity;
import com.diostock.diostock.download.DownloadTaskCliente;
import com.diostock.diostock.download.UploadTask;

import java.util.ArrayList;

/**
 * Created by IMT 02 on 17/01/2017.
 */

public class CustomListClient extends BaseAdapter implements ListAdapter {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    private ArrayList<Cliente> list = new ArrayList<Cliente>();
    private Context context;



    public CustomListClient(ArrayList<Cliente> list, Context context) {
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
        //just return 0 if your list items do not have an Id variable.
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
                //do something
                //new DownloadTaskCliente(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://www.jmksistemas.com.br/TEST/cliente/listar");
                new DownloadTask((AppCompatActivity) context,EXTRA_MESSAGE,DisplayMessageActivity.class)
                        .execute("http://www.jmksistemas.com.br/TEST/cliente/apagar/"+position);

                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                Intent intent = new Intent(context, UpClientActivity.class);
                intent.putExtra(UpClientActivity.EXTRA_PARCELABLE, (Parcelable) list.get(position));
                context.startActivity(intent);
                /*new UploadTask((AppCompatActivity) context,EXTRA_MESSAGE,DisplayMessageActivity.class,list.get(position))
                        .execute("http://www.jmksistemas.com.br/TEST/cliente/atualizar");*/
                notifyDataSetChanged();
            }
        });


        return view;
    }
}