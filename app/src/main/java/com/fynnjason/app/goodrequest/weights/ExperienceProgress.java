package com.fynnjason.app.goodrequest.weights;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;

import com.fynnjason.app.goodrequest.R;

/**
 * Created by FynnJason.
 * Function：带经验值的进度条
 */
public class ExperienceProgress extends ProgressBar {

    private Paint mTextPaint;
    private String mText;
    private Rect mRect;

    public ExperienceProgress(Context context) {
        super(context);
        init();
    }

    public ExperienceProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExperienceProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(getResources().getColor(R.color.black));
        mTextPaint.setTextSize(sp2px(10));
        mRect = new Rect();
    }

    @Override
    public synchronized void setProgress(int progress) {
        setText(progress);
        super.setProgress(progress);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.getTextBounds(mText, 0, mText.length(), mRect);
        canvas.drawText(mText, getWidth() / 2 , getHeight() / 2 - mRect.centerY(), mTextPaint);
    }

    private void setText(int progress) {
        mText = progress + "/" + getMax();
    }

    private int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }
}
