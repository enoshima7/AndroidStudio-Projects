package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class contextMenu extends MainActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        tv = (TextView)this.findViewById(R.id.sentencontextMenu_sente);
        this.registerForContextMenu(tv);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, Menu.NONE, "古诗");
        menu.add(0, 1, Menu.NONE, "诗句");
        menu.add(0, 2, Menu.NONE, "哈哈哈");
        menu.add(0, 3, Menu.NONE, "嘻嘻嘻");
    }

}
