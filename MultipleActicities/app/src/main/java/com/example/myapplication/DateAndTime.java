package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DateAndTime extends MainActivity {
    EditText date;
    EditText time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);
    }
    public void sendDate(View view) {

        date = (EditText)findViewById(R.id.datetime);
        time = (EditText)findViewById(R.id.timestr);
        String times = time.getText().toString();
        String dates = date.getText().toString();

        // start the SecondActivity
        Intent intent = new Intent(this, MainInterface.class);
        intent.putExtra("time", times);
        intent.putExtra("date", dates);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case 1:
                Toast.makeText(this,"进入主页面",Toast.LENGTH_SHORT).show();
                intent=new Intent(this,MainInterface.class);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(this,"进入ContextMenu",Toast.LENGTH_SHORT).show();
                intent=new Intent(this,contextMenu.class);
                startActivity(intent);
                break;
            case 3:
                Toast.makeText(this,"进入对话框示例",Toast.LENGTH_SHORT).show();
                intent=new Intent(DateAndTime.this, dialogBox.class);
                startActivity(intent);
                break;
            case 4:
                Toast.makeText(this,"进入ListView",Toast.LENGTH_SHORT).show();
                intent=new Intent(DateAndTime.this, ListView.class);
                startActivity(intent);
                break;
            case 5:
                Toast.makeText(this,"进入设置日期与时间",Toast.LENGTH_SHORT).show();
                intent=new Intent(DateAndTime.this, DateAndTime.class);
                startActivity(intent);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
