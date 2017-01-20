
package com.diostock.diostock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diostock.diostock.activity.add.AddClientActivity;

public class DisplayMessageActivity extends AppCompatActivity {
//ok
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String code = intent.getStringExtra(MainActivity.EXTRA_CODE);
        if(code!=null&&message!=null){
            message+=code;
        }else if(code!=null&&message==null){
            message=code;
        }
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
//
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }
    public void sendMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

