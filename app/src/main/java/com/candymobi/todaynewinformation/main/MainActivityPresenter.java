package com.candymobi.todaynewinformation.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.candymobi.todaynewinformation.Mvp.base.BaseMvpPresenter;
import com.candymobi.todaynewinformation.R;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.Iview> implements IMainActivityContract.IPresenter {

    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentFragmentIndex;
    int mCurrentCheckedId;
    private int mTopPosition;
    private int mBottomPosition;

    public MainActivityPresenter(IMainActivityContract.Iview view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.Iview getEmptyView() {
        return IMainActivityContract.emptyView;
    }


    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);
    }


    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mFragments[i] != null) {
                hideFragment(mFragments[i]);
            }
        }
        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }
    }

    @Override
    public int getCurrentCheckedIndex() {
        return
                mCurrentFragmentIndex;
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }


    // 记录当前角标
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentCheckedId = R.id.str_main_shanghai;
                mTopPosition = 0;
                break;
            case 1:
                mCurrentCheckedId = R.id.str_main_hangzhou;
                mTopPosition = 1;
                break;
            case 2:
                mCurrentCheckedId = R.id.str_main_beijing;
                mBottomPosition = 2;
                break;
            case 3:
                mCurrentCheckedId = R.id.str_main_ShenZhen;
                mBottomPosition = 3;
                break;
        }
    }

    // 创建当前fragment
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()) {
            getView().showFragment(mFragment);
        } else {
            getView().addFragment(mFragment);
        }
    }

    private void hideFragment(Fragment mFragment) {
        if (mFragment != null && mFragment.isVisible()) {
            getView().hideFragment(mFragment);
        }

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }
}
