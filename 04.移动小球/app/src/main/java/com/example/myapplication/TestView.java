package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TestView extends View {
    int x = 150,y=50;
    public TestView(Context context, AttributeSet attrs){
        super(context,attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.CYAN);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x,y,30,paint);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(600, 600, 800, 800, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(x<=800&&x>=600&&y<=800&&y>=600){
            System.exit(0);
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            x = (int) event.getX();
            y = (int) event.getY();
            this.invalidate();
            return true;
        }else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                x = (int) event.getX();
                y = (int) event.getY();
                this.invalidate();
                return true;
            }
        return true;
    }
}
