package com.example.myfirstapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class TouchArea extends View{
    private final static int AreaNum = TestOneActivity.granularityNum;
    private final static int TouchAreaWidth = 200;
    private final static int pointerWidth = 150; //指针pointer
    private final static int waitingAreaHalfLength = TestOneActivity.waitingHalfLength;
    private final static int firstAreaHalfLength = TestOneActivity.firstGranHalfLength + waitingAreaHalfLength;
    private final static int secondAreaHalfLength = TestOneActivity.secondGranHalfLength + firstAreaHalfLength;
    private final static int thirdAreaHalfLength = TestOneActivity.thirdGranHalfLength + secondAreaHalfLength;


    private Paint paint = null;

    private RectF pointerRect = null;
    private RectF waitRect = null;
    private RectF firstRect = null;
    private RectF secondRect = null;
    private RectF thirdRect = null;

    public TouchArea(Context context, float x, float y, float pointerPos) {
        super(context);
        paint = new Paint();
        pointerRect = new RectF(0, pointerPos, pointerWidth, pointerPos + 10);
        waitRect = new RectF(x - TouchAreaWidth / 2.0f, y - waitingAreaHalfLength,
                x + TouchAreaWidth / 2.0f, y + waitingAreaHalfLength);
        firstRect = new RectF(x - TouchAreaWidth / 2.0f, y - firstAreaHalfLength,
                x + TouchAreaWidth / 2.0f, y + firstAreaHalfLength);
        secondRect = new RectF(x - TouchAreaWidth / 2.0f, y - secondAreaHalfLength,
                x + TouchAreaWidth / 2.0f, y + secondAreaHalfLength);
        thirdRect = new RectF(x - TouchAreaWidth / 2.0f, y - thirdAreaHalfLength,
                x + TouchAreaWidth / 2.0f, y + thirdAreaHalfLength);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(AreaNum == 3) {
            paint.setARGB(0x64, 0xff, 0xff, 0x00);
            canvas.drawRect(thirdRect, paint);
        }
        if(AreaNum >= 2) {
            paint.setARGB(0x64, 0x99, 0xdd, 0x00);
            canvas.drawRect(secondRect, paint);
        }

        paint.setARGB(0x64, 0x10, 0xff, 0xff);
        canvas.drawRect(firstRect, paint);
        paint.setAlpha(0x00);
        canvas.drawRect(waitRect, paint);
        paint.setARGB(0xff, 0xff, 0x00, 0xff);
        canvas.drawRect(pointerRect, paint);
    }

}
