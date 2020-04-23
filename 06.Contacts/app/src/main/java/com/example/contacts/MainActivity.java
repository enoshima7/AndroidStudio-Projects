package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    static EditText mEditText01;
    static EditText mEditText02;
    static EditText mEditText03;
    static EditText mEditText04;
    Cursor cursor;
    Button createBtn,openBtn,upBtn,downBtn,addBtn,updateBtn,deleteBtn,closeBtn;
    SQLiteDatabase db;
    DBConnection helper;
    public int id_this;
    Bundle savedInstancestate;
    static String TABLE_NAME = "Users";
    static String ID = "_id";
    static String USER_NAME = "user_name";
    static String ADDRESS = "address";
    static String TELEPHONE = "telephone";
    static String MAIL_ADDRESS = "mail_address";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText01 = (EditText)findViewById(R.id.editText1);
        mEditText02 = (EditText)findViewById(R.id.editText2);
        mEditText03 = (EditText)findViewById(R.id.editText3);
        mEditText04 = (EditText)findViewById(R.id.editText4);
        createBtn = (Button)findViewById(R.id.createDatebase1);
        createBtn.setOnClickListener(new ClickEvent());
        openBtn = (Button)findViewById(R.id.openDatebase1);
        openBtn.setOnClickListener(new ClickEvent());
        upBtn = (Button)findViewById(R.id.up1);
        upBtn.setOnClickListener(new ClickEvent());
        downBtn = (Button)findViewById(R.id.down1);
        downBtn.setOnClickListener(new ClickEvent());
        addBtn = (Button)findViewById(R.id.add1);
        addBtn.setOnClickListener(new ClickEvent());
        updateBtn = (Button)findViewById(R.id.update1);
        updateBtn.setOnClickListener(new ClickEvent());
        deleteBtn = (Button)findViewById(R.id.delete1);
        deleteBtn.setOnClickListener(new ClickEvent());
        closeBtn = (Button)findViewById(R.id.clear1);
        closeBtn.setOnClickListener(new ClickEvent());
    }

    class ClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.createDatebase1:
                    helper = new DBConnection(MainActivity.this);
                    SQLiteDatabase db = helper.getWritableDatabase();
                    break;
                case R.id.openDatebase1:
                    db = openOrCreateDatabase("db2",
                            Context.MODE_PRIVATE,null);
                    cursor = db.query("Users", null,null,null,null, null,null);
                    cursor.moveToNext();
                    upBtn.setClickable(true);
                    deleteBtn.setClickable(true);
                    downBtn.setClickable(true);
                    updateBtn.setClickable(true);
                    break;
                case R.id.up1:
                    if(!cursor.isFirst())
                        cursor.moveToPrevious();
                    datashow();
                    break;
                case R.id.down1:
                    if(!cursor.isLast())
                        cursor.moveToNext();
                    datashow();
                    break;
                case R.id.add1:
                    add();
                    onCreate(savedInstancestate);
                    break;

                case R.id.update1:
                    update();
                    onCreate(savedInstancestate);
                    break;

                case R.id.delete1:
                    delete();
                    onCreate(savedInstancestate);
                    break;

                case R.id.clear1:
                    cursor.close();
                    mEditText01.setText("数据库已关闭");
                    mEditText02.setText("数据库已关闭");
                    mEditText03.setText("数据库已关闭");
                    mEditText04.setText("数据库已关闭");
                    upBtn.setClickable(false);
                    deleteBtn.setClickable(false);
                    addBtn.setClickable(false);
                    downBtn.setClickable(false);
                    updateBtn.setClickable(false);
                    break;
            }
        }
    }
    private void datashow() {
        id_this = Integer.parseInt(cursor.getString(0));
        String user_name_this = cursor.getString(1);
        String telephone_this = cursor.getString(2);
        String address_this = cursor.getString(3);
        String mail_address_this = cursor.getString(4);
        mEditText01.setText(user_name_this);
        mEditText02.setText(telephone_this);
        mEditText03.setText(address_this);
        mEditText04.setText(mail_address_this);
    }
    private void add() {
        ContentValues values1 = new ContentValues();
        values1.put(USER_NAME,MainActivity.mEditText01.getText().toString());
        values1.put(TELEPHONE,MainActivity.mEditText02.getText().toString());
        values1.put(ADDRESS,MainActivity.mEditText03.getText().toString());
        values1.put(MAIL_ADDRESS,MainActivity.mEditText04.getText().toString());
        SQLiteDatabase db2 = helper.getWritableDatabase();
        db2.insert(TABLE_NAME,null,values1);
        db2.close();
    }
    private void update() {
        ContentValues values1 = new ContentValues();
        values1.put(USER_NAME,MainActivity.mEditText01.getText().toString());
        values1.put(TELEPHONE,MainActivity.mEditText02.getText().toString());
        values1.put(ADDRESS,MainActivity.mEditText03.getText().toString());
        values1.put(MAIL_ADDRESS,MainActivity.mEditText04.getText().toString());
        String where1 = ID + " = " + id_this;
        SQLiteDatabase db1 = helper.getWritableDatabase();
        db1.update(TABLE_NAME,values1,where1,null);
        db.close();
    }
     void delete() {
        String where = ID + " = " + id_this;
        db.delete(TABLE_NAME,where,null);
        db = helper.getWritableDatabase();
        db.close();
    }


}
