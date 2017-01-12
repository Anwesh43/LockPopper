package com.anwesome.games.lockpopper.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by anweshmishra on 27/10/16.
 */
public class Rotator {
    private PointF pivot,start,end;
    private float deg = 0;
    private float direction  = 1;
    public Rotator(PointF pivot,float y,float gap) {
        this.pivot = pivot;
        this.start = new PointF(0,-y);
        this.end = new PointF(0,-y-gap);
    }
    public void draw(Canvas canvas,Paint paint) {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        canvas.save();
        canvas.translate(pivot.x,pivot.y);
        canvas.rotate(deg);
        canvas.drawLine(start.x,start.y,end.x,end.y,paint);
        canvas.restore();
    }
    public void move() {
        deg+=10*direction;
        if(deg < 0 ){
            deg = 360+deg;
        }
        deg  %= 360;
    }
    public void toggleDirection() {
        direction*=-1;
    }
    public float getDeg() {
        return deg;
    }
}
