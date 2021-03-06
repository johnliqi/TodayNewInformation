package com.candymobi.todaynewinformation.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.VideoView;

public class FullScreenVideoView extends VideoView {
    public FullScreenVideoView(Context context) {
        super(context);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      //  super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getDefaultSize(0,widthMeasureSpec);
        DisplayMetrics dm = new DisplayMetrics();
        //最大限度的展示宽和高
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);

        setMeasuredDimension(width, height);
    }
}
