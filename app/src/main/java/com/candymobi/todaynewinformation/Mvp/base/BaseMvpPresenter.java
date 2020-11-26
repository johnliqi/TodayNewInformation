package com.candymobi.todaynewinformation.Mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.candymobi.todaynewinformation.Mvp.IMvpView;
import com.candymobi.todaynewinformation.Mvp.presenter.LifeCircleMvpPresenter;

import java.lang.ref.WeakReference;

/*
 p的中间层
 */
public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCircleMvpPresenter<T> {
    @Override
    protected T getEmptyView() {
        return null;
    }

    protected WeakReference<T> weakReference;

    public BaseMvpPresenter(T view) {
        super(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
