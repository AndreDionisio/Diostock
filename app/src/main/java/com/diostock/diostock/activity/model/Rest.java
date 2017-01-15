package com.diostock.diostock.activity.model;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IMT 02 on 15/01/2017.
 */

public class Rest {
    private long code = -1;
    private String message = null;
    private ArrayList<? extends Parcelable> t = null;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<? extends Parcelable> getT() {
        return t;
    }

    public void setT(ArrayList<? extends Parcelable> t) {
        this.t = t;
    }
}
