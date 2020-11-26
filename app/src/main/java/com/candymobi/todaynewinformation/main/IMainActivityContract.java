package com.candymobi.todaynewinformation.main;

import android.support.v4.app.Fragment;

import com.candymobi.todaynewinformation.Mvp.ILifeCircle;
import com.candymobi.todaynewinformation.Mvp.IMvpView;
import com.candymobi.todaynewinformation.Mvp.presenter.MvpController;

public interface IMainActivityContract {
    interface Iview extends IMvpView {


        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }

    interface IPresenter extends ILifeCircle {

        void initHomeFragment();

        int getCurrentCheckedIndex();

        int getTopPosition();

        int getBottomPosition();

        void replaceFragment(int mCurrentFragmentIndex);
    }

    Iview emptyView = new Iview() {

        @Override
        public void addFragment(Fragment mFragment) {

        }


        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
