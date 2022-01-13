package com.example.myfirstapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LabelInit {

    static class Label extends View {
        private final static int labelWidth = 100;

        private Paint paint = null;
        private RectF labelR = null;

        public Label(Context con, int labelLength) {
            super(con);
            paint = new Paint();
            labelR = new RectF(0, 0, labelWidth, labelLength);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawRect(labelR, paint);
        }
    }


    public static void Init(Context con, LinearLayout linearLayout, int labelLength, int labelNum, int labelIntervalLength) {
//        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, labelIntervalLength);
//        LinearLayout.LayoutParams labelParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, labelLength);

        String textContent = con.getString(R.string.testOneActivity_textViewContent_text); //显示文字
        String textContent2 = con.getString(R.string.testOneActivity_textViewFocus_text);
        String textContent3 = con.getString(R.string.testOneActivity_textViewFocus_text3);
        String textContent5 = con.getString(R.string.testOneActivity_textViewFocus_text5);
    /*    {
            TextView textView = new TextView(con);
            //TextView textViewf = new TextView(con);
            //textViewf.setTextColor(android.graphics.Color.RED);

            textView.setText(textContent);
            textView.setText(textContent2);
            textView.setLayoutParams(textParams);
            linearLayout.addView(textView);
            //linearLayout.addView(textViewf);
        }
     */
        for(int i = 0; i < labelNum; i++) {
            Label label = new LabelInit.Label(con, labelLength);
            //label.setLayoutParams(labelParams);
            linearLayout.addView(label);
            TextView textView = new TextView(con);
            TextView textViewf = new TextView(con);
            TextView textViewf3 = new TextView(con);
            TextView textViewf5 = new TextView(con);
            textViewf.setTextColor(android.graphics.Color.RED);
            textViewf3.setTextColor(android.graphics.Color.RED);
            textViewf5.setTextColor(android.graphics.Color.RED);
            textView.setText(textContent);
            textViewf.setText(textContent2);
            textViewf3.setText(textContent3);
            textViewf5.setText(textContent5);
            //textView.setLayoutParams(textParams);
            linearLayout.addView(textView);
            linearLayout.addView(textViewf);

            //linearLayout.addView(textViewf3); 控制高亮文本
            //linearLayout.addView(textViewf5);
        }
    }
}