package com.diostock.diostock.download;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.JsonToken;

import com.diostock.diostock.DownloadTask;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.activity.model.Rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IMT 02 on 06/01/2017.
 */

public class DownloadTaskCliente extends DownloadTask {
    ArrayList<Cliente> clienteList = null;
    Rest rest = new Rest();
    public DownloadTaskCliente(AppCompatActivity activity, String EXTRA_MESSAGE, Class next){
        super(activity,EXTRA_MESSAGE,next);
    }
    @Override
    protected String doInBackground(String... urls) {
        try {
            clienteList = loadFromNetwork(urls[0]);
            return null;
        } catch (IOException e) {
            return getActivity().getString(R.string.connection_error);
        }
    }

    /**
     * Uses the logging framework to display the output of the fetch
     * operation in the log fragment.
     */
    @Override
    protected void onPostExecute(String result) {
        //Log.i(TAG, result);
        Intent intent = new Intent(getActivity(), getNext());//DisplayMessageActivity.class);
        intent.putParcelableArrayListExtra("clienteList",  clienteList);
        //fazer um toast do rest
        getActivity().startActivity(intent);
    }
    /** Initiates the fetch operation. */
    private ArrayList<Cliente> loadFromNetwork(String urlString) throws IOException {
        InputStream stream = null;
        ArrayList<Cliente> str =null;

        try {
            stream = downloadUrl(urlString);
            rest = readJsonStream(stream);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return (ArrayList<Cliente>) rest.getT();
    }
    public Rest readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    public Rest readMessagesArray(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            rest=readMessage(reader);
        }
        reader.endObject();
        return rest;
    }

    public Rest readMessage(JsonReader reader) throws IOException {
       /* {
            "code": 1,
                "message": "Entities returned Successfully !",
                "t":    [*/

        long code = -1;
        String message = null;
        ArrayList<Cliente> t = null;

        // Cliente user = null;
        //List<Double> geo = null;

        //reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("code")) {
                rest.setCode(reader.nextLong());
            } else if (name.equals("message")) {
                rest.setMessage(reader.nextString());
            } else if (name.equals("t") && reader.peek() != JsonToken.NULL) {
                t = readClientArray(reader);
                rest.setT(t);
                //} else if (name.equals("user")) {
                //user = readUser(reader);
            } else {
                reader.skipValue();
            }
        }
        //reader.endObject();
        return rest;
    }

    public ArrayList<Cliente> readClientArray(JsonReader reader) throws IOException {
        ArrayList<Cliente> clienteList = new ArrayList<Cliente>();

        reader.beginArray();
        while (reader.hasNext()) {
            clienteList.add(readCliente(reader));
        }
        reader.endArray();
        return clienteList;
    }

    public Cliente readCliente(JsonReader reader) throws IOException {
        long id = -1;
        String codigo = null;
        String nome = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextLong();
            } else if (name.equals("codigo")&& reader.peek() != JsonToken.NULL) {
                codigo = reader.nextString();
            } else if (name.equals("nome")&& reader.peek() != JsonToken.NULL) {
                nome = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Cliente(id, codigo,nome);
    }

}
