package com.example.myfirstapplication;


import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestOneActivity2 extends AppCompatActivity {
    final static int waitingHalfLength = 50;
    // 1 <= granularityNum <= 3
    final static int granularityNum = 3;
    // Works when granularityNum = 3
    final static int thirdGranHalfLength = 200;
    final static int thirdGranSpeed = 4;
    // Works when granularityNum >= 2
    final static int secondGranHalfLength = 200;
    final static int secondGranSpeed = 2;

    final static int firstGranHalfLength = 100;
    final static int firstGranSpeed = 1;

    final static int labelNum = 20;
    final static int labelIntervalLength = 1000;
    final static int labelLength = 200;

    private LinearLayout mLayout;
    private ScrollView mScrollView;
    private Handler mHandler;
    private FrameLayout mFrameLayout;

    private int perMoveY;
    private int windowHeight;
    private int beginTestY;

    private long scrollingTime = 0;
    private int winTime = 0;
    private int loseTime = 0;

    private Runnable ScrollRunnable = new Runnable() {

        @SuppressLint("NewApi")
        @Override
        public void run() {
            // TODO Auto-generated method stub
            int off = mLayout.getMeasuredHeight() - mScrollView.getHeight();// 判断高度
            if (off > 0) {
                mScrollView.scrollBy(0, perMoveY);
                if (mScrollView.getScaleY() == off) {
                    Thread.currentThread().interrupt();
                } else {
                    mHandler.postDelayed(this, 1);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mHandler = new Handler();
        mScrollView = findViewById(R.id.scl_testOne);
        mLayout = findViewById(R.id.linearLayout);
        mFrameLayout = findViewById(R.id.frameLayout);

        LabelInit2.Init(TestOneActivity2.this, mLayout, labelLength, labelNum, labelIntervalLength);

        Rect outRect = new Rect();
        mLayout.getWindowVisibleDisplayFrame(outRect);
        windowHeight = outRect.bottom;

        TextView mTitle = findViewById(R.id.textViewTitle);
        //ImageView mImage = findViewById(R.id.imageView);
        //beginTestY = mTitle.getLayoutParams().height + mImage.getLayoutParams().height + labelIntervalLength;

        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            private long startScrolling;
            private float lastDownY;
            private boolean isScrolling = false;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float y = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        startScrolling = System.currentTimeMillis();
                        lastDownY = y;
                        mFrameLayout.addView(new TouchArea(TestOneActivity2.this, event.getX(), event.getY(), windowHeight / 2.0f));
                        break;
                    }

                    case MotionEvent.ACTION_MOVE: {
                        if(Math.abs(y - lastDownY) < waitingHalfLength) {
                            perMoveY = 0;
                        }else if(Math.abs(y - lastDownY) >= secondGranHalfLength + firstGranHalfLength + waitingHalfLength) {
                            if(y > lastDownY)    perMoveY = thirdGranSpeed;
                            else perMoveY = -thirdGranSpeed;
                        }else if(Math.abs(y - lastDownY) >= firstGranHalfLength + waitingHalfLength) {
                            if(y > lastDownY)    perMoveY = secondGranSpeed;
                            else perMoveY = -secondGranSpeed;
                        }else if(Math.abs(y - lastDownY) >= waitingHalfLength) {
                            if(y > lastDownY)   perMoveY = firstGranSpeed;
                            else perMoveY = -firstGranSpeed;
                        }

                        if(!isScrolling) {
                            isScrolling = true;
                            mHandler.post(ScrollRunnable);
                        }
                        break;
                    }

                    case MotionEvent.ACTION_UP: {
                        scrollingTime += System.currentTimeMillis() - startScrolling;
                        int zoomCenterY = mScrollView.getScrollY() + windowHeight / 2;

                        if((zoomCenterY - beginTestY) % (labelLength + labelIntervalLength) <= labelLength) {
                            winTime++;
                        }else {
                            loseTime++;
                        }
                        if(isScrolling) {
                            isScrolling = false;
                            mHandler.removeCallbacks(ScrollRunnable);
                        }
                        mFrameLayout.removeViewAt(1);
                        break;
                    }
                }

                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        ResDump.testResultInit((int)(scrollingTime / 1000L), winTime / (float)labelNum, 0);
        ResDump.dump(TestOneActivity2.this, 1);
        super.onDestroy();
    }
}