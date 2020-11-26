package com.candymobi.todaynewinformation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.candymobi.todaynewinformation.Mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter {
    CountTimerTask countTimer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }

    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

    public void initTimer() {
        countTimer = new CountTimerTask(5, new CountTimerTask.ICountHandler() {
            @Override
            public void onTicker(int time) {

                getView().setTextCountTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTextCountTimer("跳过");

            }
        });
        countTimer.start();
    }

    public void cancel() {
        countTimer.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("SplashTimerPresenter", "ondestory");
    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }
}
