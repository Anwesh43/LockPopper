package com.anwesome.games.lockpopper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.anwesome.games.lockpopper.objects.Ball;
import com.anwesome.games.lockpopper.objects.Container;
import com.anwesome.games.lockpopper.objects.Rotator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 27/10/16.
 */
public class GameView extends View{
    private int time = 0;
    private Container container;
    private Rotator rotator;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private List<Ball> balls = new ArrayList<>();
    private Ball currentBall;
    int level = 1;
    public GameView(Context context) {
        super(context);
    }
    public void init(int w,int h) {
        container = new Container(w/2,h/2,w/10,w/6);
        rotator = new Rotator(new PointF(w/2,h/2),w/10,w/15);
        balls = BallCreator.createBalls(level,new PointF(w/2,h/2),w/10,w/6);
        if(balls.size()>0) {
            currentBall = balls.get(0);
        }
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            init(canvas.getWidth(),canvas.getHeight());
        }
        canvas.drawColor(Color.parseColor("#69F0AE"));
        container.draw(canvas,paint,balls.size());
        rotator.draw(canvas,paint);
        rotator.move();
        currentBall.draw(canvas,paint);
        time++;
        try {
            Thread.sleep(100);
            invalidate();
        }
        catch(Exception ex) {

        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if(rotator != null) {
                if(currentBall.closeTo(rotator.getDeg())) {
                    balls.remove(0);
                    if(balls.size() == 0) {
                        time = -1;
                        level++;
                    }
                    else {
                        currentBall = balls.get(0);
                        rotator.toggleDirection();
                    }
                }
            }
        }
        return true;
    }
}


//We will create some objects like the thing that is rotating and the balls it is catching
