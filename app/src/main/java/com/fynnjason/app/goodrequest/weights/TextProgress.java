package com.fynnjason.app.goodrequest.weights;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.fynnjason.app.goodrequest.R;
import com.fynnjason.app.goodrequest.utils.LogUtils;

/**
 * Created by FynnJason.
 * Function：带文字居中显示的Progress
 */
public class TextProgress extends View {

    private int mBgColor;
    private int mProColor;
    private int mTextColor;
    private float mTextSize;
    private String mText;
    private int mMaxValue;
    private int mValue;

    private Paint mBgPaint;
    private Paint mProPaint;
    private Paint mTextPaint;

    private int mWidth;
    private int mHeight;

    public TextProgress(Context context) {
        super(context, null);
    }

    public TextProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        LogUtils.e("B");
        obtainAttrs(attrs);
    }

    public TextProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LogUtils.e("C");
        obtainAttrs(attrs);
    }

    private void obtainAttrs(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.TextProgress);
        mBgColor = ta.getColor(R.styleable.TextProgress_bgColor, mBgColor);
        mProColor = ta.getColor(R.styleable.TextProgress_proColor, mProColor);
        mTextColor = ta.getColor(R.styleable.TextProgress_textColor, mTextColor);
        mTextSize = ta.getDimension(R.styleable.TextProgress_textSize, mTextSize);
        mMaxValue = ta.getInt(R.styleable.TextProgress_maxValue, mMaxValue);
        mValue = ta.getInt(R.styleable.TextProgress_value, mValue);
        ta.recycle();
        initView();
    }

    private void initView() {
        mBgPaint = new Paint();
        mBgPaint.setAntiAlias(true);
        mBgPaint.setColor(mBgColor);

        mProPaint = new Paint();
        mProPaint.setAntiAlias(true);
        mProPaint.setColor(mProColor);

        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        } else {
            mWidth = Math.min(mWidth, widthSize);
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        } else {
            mHeight = Math.min(heightSize, mHeight);

        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF bgRectF = new RectF(0f, 0f, mWidth, mHeight);
        canvas.drawRoundRect(bgRectF, mHeight / 2, mHeight / 2, mBgPaint);

        RectF proRectF = new RectF(0f, 0f, mWidth * mValue / mMaxValue, mHeight);
        canvas.drawRoundRect(proRectF, mHeight / 2, mHeight / 2, mProPaint);

        mTextPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mText, bgRectF.centerX(), mHeight - mHeight / 4, mTextPaint);
    }

    private int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    private int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }

    public void setText(String text) {
        mText = text;
        invalidate();
    }

    public void setMaxValue(int maxValue) {
        mMaxValue = maxValue;
    }

    public void setValue(int value) {
        mValue = value;
    }
}
