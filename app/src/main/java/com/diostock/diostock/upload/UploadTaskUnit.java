package com.diostock.diostock.upload;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonWriter;

import com.diostock.diostock.activity.model.Fornecedor;
import com.diostock.diostock.activity.model.Unidade;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by IMT 02 on 28/01/2017.
 */

public class UploadTaskUnit extends UploadTask {
    public UploadTaskUnit(AppCompatActivity activity, String EXTRA_MESSAGE, Class next, Parcelable msg) {
        super(activity,EXTRA_MESSAGE,next,msg);
    }
    @Override
    public void writeMessage(JsonWriter printout, Parcelable parcel) throws JSONException, IOException {
        Unidade unidade = (Unidade) parcel;
        printout.name("id").value(unidade.getId());
        printout.name("unidade").value(unidade.getUnidade());
        printout.name("descricao").value(unidade.getDescricao());
    }
}
