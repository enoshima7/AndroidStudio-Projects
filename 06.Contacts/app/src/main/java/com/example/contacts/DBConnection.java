package com.example.contacts;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnection extends SQLiteOpenHelper {

    static final String Database_name = "db2";
    static  final  int Database_Version = 1;
    SQLiteDatabase db;
    public int id_this;
    Cursor cursor;
    static String TABLE_NAME = "Users";
    static String ID = "_id";
    static String USER_NAME = "user_name";
    static String ADDRESS = "address";
    static String TELEPHONE = "telephone";
    static String MAIL_ADDRESS = "mail_address";

    DBConnection(Context ctx) {
        super(ctx, Database_name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String sql = "CREATE TABLE " + TABLE_NAME +"("
                + ID + " INTEGER primary key autoincrement, "
                + USER_NAME + " text not null, "
                + TELEPHONE + " text not null, "
                + ADDRESS + " text not null, "
                + MAIL_ADDRESS + " text not null "+");";
        database.execSQL((sql));
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}
}
