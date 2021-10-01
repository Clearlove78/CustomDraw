package com.example.customdraw;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class CustomGraph extends View {
    private Paint mPaint;

    private float mRadius = 100f;

    public float pointX = mRadius;
    public float pointY = mRadius;

    private boolean moveable;

    private int colorArray[] = {Color.WHITE,Color.GREEN,Color.YELLOW, Color.RED};
    private int paintColor = colorArray[0]; //定义画笔默认颜色
    Context context;
    public CustomGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mPaint = new Paint();
        mPaint.setColor(paintColor);
    }

    public CustomGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomGraph(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setPaintRandomColor();
        canvas.drawColor(Color.BLACK);
        Paint surfaceBackground = new Paint();
        for (int i = 0; i < 10; i++) {
            Paint paint1 = new Paint();
            Paint paint = paint1;
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setColor(Color.YELLOW);
            paint.setTextSize(24);
            int x = (int) (Math.random() * 600 + 200);
            int y = (int) (Math.random() * 1000 + 100);
            int r = (int) (Math.random() * 250 + 20);
            canvas.save();
            canvas.translate(x, y);
            canvas.drawLine(0, 0, r, 0, paint);
            canvas.translate(r, 0);
            canvas.rotate(144);
            canvas.drawLine(0, 0, r, 0, paint);
            canvas.translate(r, 0);
            canvas.rotate(144);
            canvas.drawLine(0, 0, r, 0, paint);
            canvas.translate(r, 0);
            canvas.rotate(144);
            canvas.drawLine(0, 0, r, 0, paint);
            canvas.translate(r, 0);
            canvas.rotate(144);
            canvas.drawLine(0, 0, r, 0, paint);
            canvas.restore();
        }
        surfaceBackground.setColor(Color.BLACK);
        canvas.drawCircle(pointX, pointY, mRadius, mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX;
        float touchY;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                touchX = event.getX();
                touchY = event.getY();
                if(touchX > pointX - mRadius && touchX < pointX + mRadius && touchY > pointY - mRadius && touchY < pointY + mRadius){
                    moveable = true;
                }else{
                    moveable = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(moveable){
                    pointX = event.getX();
                    pointY = event.getY();
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
    private void setPaintRandomColor(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(colorArray.length);
        mPaint.setColor(colorArray[randomIndex]);
    }
}