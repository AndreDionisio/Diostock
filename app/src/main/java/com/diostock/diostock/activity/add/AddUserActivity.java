
package com.diostock.diostock.activity.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.diostock.diostock.DisplayMessageActivity;
import com.diostock.diostock.download.DownloadTask;
import com.diostock.diostock.R;

public class AddUserActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.diostock.diostock.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_add);
    }
    //user/criar
    public void sendUserCreateMessage(View view) {
        EditText editTextName = (EditText) findViewById(R.id.edit_user_name);
        String name = editTextName.getText().toString();
        EditText editTextEmail = (EditText) findViewById(R.id.edit_user_email);
        String email = editTextEmail.getText().toString();
        EditText editTextPassword = (EditText) findViewById(R.id.edit_user_password);
        String password = editTextName.getText().toString();
        EditText editTextRole = (EditText) findViewById(R.id.edit_user_role);
        String role = editTextEmail.getText().toString();
        new DownloadTask(this,EXTRA_MESSAGE,DisplayMessageActivity.class).execute("http://104.236.57.74:8080/DIOS/user/criar?name="+name+"&email="+email+"&password="+password+"&role="+role);

    }
}

