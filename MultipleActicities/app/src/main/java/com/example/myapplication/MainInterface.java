package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainInterface extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);
        Intent intent = getIntent();
        String time = intent.getStringExtra("time");
        String date = intent.getStringExtra("date");

        TextView dateV = (TextView) findViewById(R.id.showDate);
        TextView timeV = (TextView) findViewById(R.id.showTime);
        dateV.setText(date);
        timeV.setText(time);
    }
}
