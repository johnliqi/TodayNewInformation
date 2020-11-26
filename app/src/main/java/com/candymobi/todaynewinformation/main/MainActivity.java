package com.candymobi.todaynewinformation.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.candymobi.todaynewinformation.Mvp.IMvpView;
import com.candymobi.todaynewinformation.Mvp.base.BaseActivity;
import com.candymobi.todaynewinformation.Mvp.base.ViewInject;
import com.candymobi.todaynewinformation.Mvp.presenter.MvpController;
import com.candymobi.todaynewinformation.R;
import com.candymobi.todaynewinformation.main.Tools.MainContentTool;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(getMainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview {
    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);


    @BindView(R.id.float_btn)
    FloatingActionButton floatBtn;
    @BindView(R.id.str_main_shanghai)
    RadioButton strMainShanghai;
    @BindView(R.id.str_main_hangzhou)
    RadioButton strMainHangzhou;
    @BindView(R.id.rb_Top)
    RadioGroup rbMainTop;
    @BindView(R.id.fLayout_main_bottom)
    FrameLayout fLayoutMainBottom;
    @BindView(R.id.str_main_beijing)
    RadioButton strMainBeijing;
    @BindView(R.id.str_main_ShenZhen)
    RadioButton strMainShenZhen;
    @BindView(R.id.rb_Bottom)
    RadioGroup rbMainBottom;
    boolean isChangeBottomButton;


    @Override
    protected void afterBindView() {
        initHomeFragment();
        changeAnimation(rbMainTop, rbMainBottom);
    }

    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    @OnClick(R.id.float_btn)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.float_btn:
                isChangeBottomButton = !isChangeBottomButton;
                if (isChangeBottomButton) {
                    changeAnimation(rbMainTop, rbMainBottom);
                    handleTopPosition();
                } else {
                    changeAnimation(rbMainBottom, rbMainTop);
                    handleBottomPosition();
                }
                break;

        }
    }

    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() !=1) {
            mPresenter.replaceFragment(MainContentTool.SHANGHAI);
            strMainShanghai.setChecked(true);
        }else {
            mPresenter.replaceFragment(MainContentTool.HANGZHOU);
            strMainHangzhou.setChecked(true);
        }


    }

//上海 杭州
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() !=3) {
            mPresenter.replaceFragment(MainContentTool.BEIJING);
            strMainBeijing.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainContentTool.SHENZHEN);
            strMainShenZhen.setChecked(true);
        }
    }

    private void changeAnimation(RadioGroup Gone, RadioGroup show) {
        //消失的动画
        Gone.clearAnimation();
        Animation goneAnimation = AnimationUtils.loadAnimation(this, R.anim.main_old_anmation);
        goneAnimation.start();
        Gone.setVisibility(View.GONE);
        show.clearAnimation();
        Animation showAnimation = AnimationUtils.loadAnimation(this, R.anim.main_new_anmation);
        show.setVisibility(View.VISIBLE);
        showAnimation.start();
    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }


}
