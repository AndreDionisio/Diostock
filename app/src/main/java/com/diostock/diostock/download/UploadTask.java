package com.diostock.diostock.download;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import android.widget.Toast;

import com.diostock.diostock.DownloadTask;
import com.diostock.diostock.MainActivity;
import com.diostock.diostock.R;
import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.activity.model.Response;
import com.diostock.diostock.activity.model.Rest;
import com.diostock.diostock.activity.up.UpClientActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by IMT 02 on 19/01/2017.
 */

public class UploadTask extends AsyncTask<String, Void, String> {
    Parcelable cliente= null;
    Response rest = new Response();
    Cliente msg = null;
    private String EXTRA_MESSAGE;
    private Class next;
    private AppCompatActivity activity;
    public UploadTask(AppCompatActivity activity, String EXTRA_MESSAGE, Class next,Cliente msg) {
        this.setActivity(activity);
        this.setEXTRA_MESSAGE(EXTRA_MESSAGE);
        this.setNext(next);
        this.msg = msg;
    }
    public String getEXTRA_MESSAGE() {
        return EXTRA_MESSAGE;
    }

    public void setEXTRA_MESSAGE(String EXTRA_MESSAGE) {
        this.EXTRA_MESSAGE = EXTRA_MESSAGE;
    }

    public Class getNext() {
        return next;
    }

    public void setNext(Class next) {
        this.next = next;
    }

    public AppCompatActivity getActivity() {
        return activity;
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
    @Override
    protected String doInBackground(String... urls) {
        try {
            cliente = loadFromNetwork(urls[0],msg);

        } catch (Exception e) {

            CharSequence text =e.getMessage()+" | "+e.getCause()+" | "+e.getLocalizedMessage();

            int duration = Toast.LENGTH_SHORT;
            Looper.prepare();
            try {
            Toast toast = Toast.makeText(getActivity(), text, duration);
            toast.show();
            } catch (Exception ex) {
                CharSequence textex =ex.getMessage()+" | "+ex.getCause()+" | "+ex.getLocalizedMessage();
            }
        }finally {
            return "";
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
        intent.putExtra(UpClientActivity.EXTRA_PARCELABLE, cliente);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, rest.getMessage());
        intent.putExtra(MainActivity.EXTRA_CODE,rest.getCode());
        //fazer um toast do rest
        getActivity().startActivity(intent);
    }



    /** Initiates the fetch operation. */
    private Cliente loadFromNetwork(String urlString,Cliente cliente) throws IOException {
        InputStream response = null;
        OutputStream request = null;
        ArrayList<Cliente> str =null;
        int statusCode = 0;
        try {
            HttpURLConnection conn = uploadUrl(urlString);

            request = conn.getOutputStream();
            writeJsonStream(request,cliente);
            statusCode = conn.getResponseCode();

            if (statusCode >= 200 && statusCode < 400) {
                // Create an InputStream in order to extract the response object
                response = conn.getInputStream();
            }
            else {
                response = conn.getErrorStream();
            }

            rest = readJsonStream(response);
        } catch (Exception e) {

            CharSequence text =e.getMessage()+" | "+e.getCause()+" | "+e.getLocalizedMessage();

            int duration = Toast.LENGTH_SHORT;
            try {
                Looper.prepare();
            Toast toast = Toast.makeText(getActivity(), text, duration);
            toast.show();
            } catch (Exception ex) {
                CharSequence textex =e.getMessage()+" | "+e.getCause()+" | "+e.getLocalizedMessage();
            }
        } finally {
            if (request != null) {
                request.close();
            }
            if (response != null&& (statusCode >= 200 && statusCode < 400) ) {
                response.close();
            }
        }
        return (Cliente) rest.getT();
    }
    public void writeJsonStream(OutputStream out,Cliente cliente) throws IOException {
        JsonWriter printout = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));

        try {
            encodeMessage(printout,cliente);
        } catch(Exception exception){
            CharSequence text =exception.getMessage()+" | "+exception.getCause()+" | "+exception.getLocalizedMessage();

            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getActivity(), text, duration);
            toast.show();
        } finally {

            printout.flush ();
            printout.close ();
        }
    }
    public void encodeMessage(JsonWriter printout ,Cliente cliente) throws JSONException, IOException {
        printout.setLenient(true);
        printout.beginObject();
        writeMessage(printout,cliente);
        printout.endObject();

    }
    public void writeMessage(JsonWriter printout ,Cliente cliente) throws JSONException, IOException {
        final JsonWriter id = printout.name("id").value(cliente.getId());
        final JsonWriter codigo = printout.name("codigo").value(cliente.getCodigo());
        final JsonWriter nome = printout.name("nome").value(cliente.getNome());
    }



    public Response readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.setLenient(true);
        try {
            return readMessage(reader);
        } finally {
            reader.close();
        }
    }



    public Response readMessage(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("code")) {
                rest.setCode(reader.nextLong());
            } else if (name.equals("message")) {
                rest.setMessage(reader.nextString());
            } else if (name.equals("t") && reader.peek() != JsonToken.NULL) {
                rest.setT(readCliente(reader));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return rest;
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
    protected HttpURLConnection uploadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestProperty( "Content-Type", "application/json" );
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("POST");
        // Start the query
        conn.connect();
        return conn;
    }

}
