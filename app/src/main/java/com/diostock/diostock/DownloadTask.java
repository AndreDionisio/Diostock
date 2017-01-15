package com.diostock.diostock;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IMT 02 on 06/01/2017.
 */

public class DownloadTask extends AsyncTask<String, Void, String> {
    private String EXTRA_MESSAGE;
    private Class next;
    public DownloadTask(AppCompatActivity activity,String EXTRA_MESSAGE,Class next){
        this.setActivity(activity);
        this.setEXTRA_MESSAGE(EXTRA_MESSAGE);
        this.setNext(next);
    }
    private AppCompatActivity activity;

    @Override
    protected String doInBackground(String... urls) {
        try {
            return loadFromNetwork(urls[0]);
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
        String message = result;
        intent.putExtra(getEXTRA_MESSAGE(), message);
        getActivity().startActivity(intent);
    }
    /** Initiates the fetch operation. */
    private String loadFromNetwork(String urlString) throws IOException {
        InputStream stream = null;
        String str ="";

        try {
            stream = downloadUrl(urlString);
            str = readIt(stream, 500);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return str;
    }
    /**
     * Given a string representation of a URL, sets up a connection and gets
     * an input stream.
     * @param urlString A string representation of a URL.
     * @return An InputStream retrieved from a successful HttpURLConnection.
     * @throws java.io.IOException
     */
    protected InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Start the query
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
    }
    /** Reads an InputStream and converts it to a String.
     * @param stream InputStream containing HTML from targeted site.
     * @param len Length of string that this method returns.
     * @return String concatenated according to len parameter.
     * @throws java.io.IOException
     * @throws java.io.UnsupportedEncodingException
     */
    private String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
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
}
