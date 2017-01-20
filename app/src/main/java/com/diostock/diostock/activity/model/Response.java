package com.diostock.diostock.activity.model;

import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by IMT 02 on 19/01/2017.
 */

public class Response {
    private long code = -1;
    private String message = null;
    private Parcelable t = null;

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

    public Parcelable getT() {
        return t;
    }

    public void setT(Parcelable t) {
        this.t = t;
    }
}
