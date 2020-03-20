package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class dialogBox extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);
    }
    public void showdialog(View view){
        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("这是普通对话框");
        alertdialogbuilder.setPositiveButton("确定", click1);
        AlertDialog alertdialog1=alertdialogbuilder.create();
        alertdialog1.show();
    }
    private DialogInterface.OnClickListener click1= new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    };
    public void showInputDialog(View view){
        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(this);
        alertdialogbuilder.setView(R.layout.dialog);
        alertdialogbuilder.setMessage("这是输入对话框");
        alertdialogbuilder.setPositiveButton("确定", click2);
        AlertDialog alertdialog1=alertdialogbuilder.create();
        alertdialog1.show();
    }
    private DialogInterface.OnClickListener click2= new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    };


}
