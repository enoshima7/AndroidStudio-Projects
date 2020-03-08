package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    TextView txt;
    Button btn1;
    Button btn2;
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
    };
    private int[] descs = {
            R.string.desc1,
            R.string.desc2,
            R.string.desc3,
            R.string.desc4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.desc);
        btn1 = (Button)findViewById(R.id.next);
        btn2 = (Button)findViewById(R.id.prev);
        iv = (ImageView)findViewById(R.id.iv);
        btn1.setOnClickListener(new myClick());
        btn2.setOnClickListener(new myClick2());
    }
    class myClick implements View.OnClickListener{
        private int index = 0;
        @Override
        public void onClick(View v) {
            index++;
            if(index>=imgs.length){
                index = 0;
            }else if(index<0){
                index = imgs.length - 1;
            }
            txt.setText(descs[index]);
            iv.setImageResource(imgs[index]);
        }
    };
    class myClick2 implements View.OnClickListener{
        private int index = 0;
        @Override
        public void onClick(View v) {
            index--;
            if(index>=imgs.length){
                index = 0;
            }else if(index<0){
                index = imgs.length - 1;
            }
            txt.setText(descs[index]);
            iv.setImageResource(imgs[index]);
        }
    }
}
