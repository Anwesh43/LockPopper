package com.anwesome.games.lockpopper.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by anweshmishra on 28/10/16.
 */
public class Ball {
    private PointF pivot,center;
    private float radius,deg;
    public Ball(PointF pivot,float innerRadius,float outerRadius,float deg) {
        this.pivot = pivot;

        this.radius = outerRadius-innerRadius;
        this.radius = radius/2;
        this.center = new PointF();
        this.center.x = 0;
        this.center.y = -innerRadius-radius;
        this.deg = deg;
    }
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#FFB74D"));
        canvas.save();
        canvas.translate(pivot.x,pivot.y);
        canvas.rotate(deg);
        canvas.drawCircle(this.center.x,this.center.y,radius,paint);
        canvas.restore();
    }
    public int hashCode() {
        return  pivot.hashCode()+center.hashCode()+(int)radius+(int)deg;
    }
    public boolean equals(Object o) {
        return ((Ball)o).hashCode() == hashCode();
    }
    public boolean closeTo(float deg) {

        return deg>=this.deg-15 && deg<=this.deg+15;
    }
}
