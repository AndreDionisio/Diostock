package com.diostock.diostock.upload;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonWriter;

import com.diostock.diostock.activity.model.Cliente;
import com.diostock.diostock.upload.UploadTask;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by IMT 02 on 28/01/2017.
 */

public class UploadTaskClient extends UploadTask {
    public UploadTaskClient(AppCompatActivity activity, String EXTRA_MESSAGE, Class next, Parcelable msg) {
        super(activity,EXTRA_MESSAGE,next,msg);
    }
    @Override
    public void writeMessage(JsonWriter printout, Parcelable parcel) throws JSONException, IOException {
        Cliente cliente = (Cliente) parcel;
        final JsonWriter id = printout.name("id").value(cliente.getId());
        final JsonWriter codigo = printout.name("codigo").value(cliente.getCodigo());
        final JsonWriter nome = printout.name("nome").value(cliente.getNome());
    }
}
