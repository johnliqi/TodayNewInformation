package com.candymobi.todaynewinformation.splash;


import android.os.Handler;

public class CountTimerTask implements Runnable {
    private int mCountTime;
    private Handler mHandler;
    private final ICountHandler mCountHandler;
    private boolean isTick;

    public CountTimerTask(int time, ICountHandler CountHandler) {
        mCountTime = time;
        mHandler = new Handler();
        mCountHandler = CountHandler;
    }

    @Override
    public void run() {
        if (isTick) {
            if (mCountHandler != null) {
                mCountHandler.onTicker(mCountTime);
            }
            if (mCountTime == 0) {
                if (mCountHandler!=null)
                mCountHandler.onFinish();
            }else {
                mCountTime = mCountTime -1;
                mHandler.postDelayed(this, 1000);
            }
        }
    }

    public void start() {
        isTick = true;
        mHandler.post(this);

    }

    public void stop() {
        isTick = false;
        mHandler.removeCallbacks(this);

    }

    public interface ICountHandler {

        void onTicker(int time);

        void onFinish();

    }
}
