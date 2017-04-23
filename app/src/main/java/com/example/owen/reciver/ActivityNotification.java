package com.example.owen.reciver;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class ActivityNotification  extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        TextView tv = new TextView(ActivityNotification.this);
        tv.setText("Greeting"+name);
        tv.setTextSize(25);
        setContentView(tv);
    }

}
