package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(Menu.NONE,1,1,"主页面");
        menu.add(Menu.NONE,2,2,"上下文菜单示例");
        menu.add(Menu.NONE,3,3,"对话框示例");
        menu.add(Menu.NONE,4,4,"ListView示例");
        menu.add(Menu.NONE,5,5,"日期时间设置");
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case 1:
                Toast.makeText(this,"进入主页面",Toast.LENGTH_SHORT).show();
                intent=new Intent(MainActivity.this,MainInterface.class);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(this,"进入ContextMenu",Toast.LENGTH_SHORT).show();
                intent=new Intent(MainActivity.this,contextMenu.class);
                startActivity(intent);
                break;
            case 3:
                Toast.makeText(this,"进入对话框示例",Toast.LENGTH_SHORT).show();
                intent=new Intent(MainActivity.this, dialogBox.class);
                startActivity(intent);
                break;
            case 4:
                Toast.makeText(this,"进入ListView",Toast.LENGTH_SHORT).show();
                intent=new Intent(MainActivity.this, ListView.class);
                startActivity(intent);
                break;
            case 5:
                Toast.makeText(this,"进入设置日期与时间",Toast.LENGTH_SHORT).show();
                intent=new Intent(MainActivity.this, DateAndTime.class);
                startActivity(intent);
                break;
                default:break;
        }
        return super.onOptionsItemSelected(item);
    }

}
