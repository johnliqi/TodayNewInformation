package com.candymobi.todaynewinformation.Mvp;

import android.content.Intent;
import android.os.Bundle;

import com.candymobi.todaynewinformation.Mvp.IMvpView;

public interface ILifeCircle {
    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument);

    void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArgument);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void destroyView();

    void onDestroy();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);
}
