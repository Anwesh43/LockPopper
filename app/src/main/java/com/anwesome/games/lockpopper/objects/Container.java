package com.anwesome.games.lockpopper.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 27/10/16.
 */
public class Container {
    private float pivotX,pivotY,r1,r2;
    public Container(float pivotX,float pivotY,float r1,float r2) {
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.r1 = r1;
        this.r2 = r2;
    }
    public void draw(Canvas canvas, Paint paint,int ballsSize) {

        paint.setStyle(Paint.Style.FILL);

        //paint.setColor(Color.GREEN);
        canvas.save();
        canvas.translate(pivotX,pivotY);
        paint.setColor(Color.parseColor("#455A64"));
        canvas.drawCircle(0,0,r2,paint);
        paint.setColor(Color.parseColor("#69F0AE"));
        canvas.drawCircle(0,0,r1,paint);
        paint.setColor(Color.parseColor("#B2EBF2"));
        paint.setTextSize(r1);
        canvas.drawText(""+ballsSize,-r1/3,0,paint);
        canvas.restore();
    }
}
