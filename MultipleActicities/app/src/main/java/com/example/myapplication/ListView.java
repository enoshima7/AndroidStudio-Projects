package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.lang.reflect.Array;

public class ListView extends MainActivity {
    private android.widget.ListView lv;
    private ListAdapter la;
    private String[] str = {"重庆市","湖北省","浙江省","上海市","广州省"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = (android.widget.ListView) findViewById(R.id.listview);
        la = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
        lv.setAdapter(la);
    }
}
