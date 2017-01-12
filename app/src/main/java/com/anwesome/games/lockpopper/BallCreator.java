package com.anwesome.games.lockpopper;

import android.graphics.PointF;

import com.anwesome.games.lockpopper.objects.Ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by anweshmishra on 28/10/16.
 */
public class BallCreator {
    public static List<Ball> createBalls(int level, PointF pivot,float innerRadius,float outerRadius) {
        List<Ball> balls = new ArrayList<>();
        Random random = new Random();
        int degs[] = {0,180};
        for(int i=0;i<level;i++) {
            int deg = degs[i%2]+random.nextInt(180);
            balls.add(new Ball(pivot,innerRadius,outerRadius,deg));
        }
        return balls;
    }
}
