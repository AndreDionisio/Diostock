package com.diostock.diostock.download;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.JsonToken;

import com.diostock.diostock.activity.model.Fornecedor;
import com.diostock.diostock.activity.model.Unidade;

import java.io.IOException;

/**
 * Created by IMT 02 on 06/01/2017.
 */

public class DownloadTaskUnit extends DownloadTaskClient {
    public DownloadTaskUnit(AppCompatActivity activity, String EXTRA_MESSAGE, Class next){
        super(activity,EXTRA_MESSAGE,next);
    }

    @Override
    public Parcelable readCliente(JsonReader reader) throws IOException {
        long id = -1;
        String unidade = null;
        String descricao = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextLong();
            } else if (name.equals("unidade")&& reader.peek() != JsonToken.NULL) {
                unidade = reader.nextString();
            } else if (name.equals("descricao")&& reader.peek() != JsonToken.NULL) {
                descricao = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Unidade(id, unidade,descricao);
    }

}
/* @Override
    protected String doInBackground(String... urls) {
        try {
            providerList = loadFromNetwork(urls[0]);
            return null;
        } catch (IOException e) {
            return getActivity().getString(R.string.connection_error);
        }
    }*/

/**
 * Uses the logging framework to display the output of the fetch
 * operation in the log fragment.
 */
    /*@Override
    protected void onPostExecute(String result) {
        //Log.i(TAG, result);
        Intent intent = new Intent(getActivity(), getNext());//DisplayMessageActivity.class);
        intent.putParcelableArrayListExtra(ListClientActivity.EXTRA_ARRAY,  providerList);
        //fazer um toast do rest
        getActivity().startActivity(intent);
    }*/
/** Initiates the fetch operation. */
   /* private ArrayList<Fornecedor> loadFromNetwork(String urlString) throws IOException {
        InputStream stream = null;
        ArrayList<Fornecedor> str =null;

        try {
            stream = downloadUrl(urlString);
            rest = readJsonStream(stream);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return (ArrayList<Fornecedor>) rest.getT();
    }*/
   /* public Rest readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }*/

    /*public Rest readMessagesArray(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            rest=readMessage(reader);
        }
        reader.endObject();
        return rest;
    }*/

    /*public Rest readMessage(JsonReader reader) throws IOException {

        long code = -1;
        String message = null;
        ArrayList<? extends Parcelable> t = null;

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
    }|*/

   /* public ArrayList<Parcelable> readClientArray(JsonReader reader) throws IOException {
        ArrayList<Parcelable> clienteList = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            clienteList.add(readCliente(reader));
        }
        reader.endArray();
        return clienteList;
    }*/