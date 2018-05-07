package com.project3.www.AutismAtEase;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PaintView extends View implements View.OnTouchListener {
    private static final String TAG = "PaintView";

    List<Point> points = new ArrayList<Point>();
    Paint paint = new Paint();

    public PaintView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);

        paint.setColor(Color.GREEN);
        //paint.set();
        paint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Drawable d = getResources().getDrawable(R.drawable.abcd);
        d.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        d.draw(canvas);
        for (Point point : points) {
            canvas.drawCircle(point.x, point.y, 15, paint);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {
        Point point = new Point();
        point.x = event.getX();
        point.y = event.getY();
        points.add(point);
        invalidate();
        Log.d(TAG, "point: " + point);
        return true;
    }
}

class Point {
    float x, y;

    @Override
    public String toString() {
        return x + ", " + y;
    }
}