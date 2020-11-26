package com.candymobi.todaynewinformation.splash;

import com.candymobi.todaynewinformation.Mvp.ILifeCircle;
import com.candymobi.todaynewinformation.Mvp.IMvpView;
import com.candymobi.todaynewinformation.Mvp.presenter.MvpController;

public interface ISplashActivityContract {
    interface Iview extends IMvpView {
        void setTextCountTimer(String timer);

    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTextCountTimer(String timer) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
