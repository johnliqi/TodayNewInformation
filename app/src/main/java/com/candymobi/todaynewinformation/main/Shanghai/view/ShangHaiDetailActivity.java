package com.candymobi.todaynewinformation.main.Shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;

import com.candymobi.todaynewinformation.Mvp.base.BaseActivity;
import com.candymobi.todaynewinformation.Mvp.base.ViewInject;
import com.candymobi.todaynewinformation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@ViewInject(getMainLayoutId = R.layout.acitivity_shanghai_detail)
public class ShangHaiDetailActivity extends BaseActivity {
    public static String mActivityOptionsCompat = "ShangHaiDetailActivity";
    @BindView(R.id.iv_detail)
    ImageView ivShanghaiDetail;

    @Override
    protected void afterBindView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initAnima();
    }

    private void initAnima() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ViewCompat.setTransitionName(ivShanghaiDetail, mActivityOptionsCompat);
            // 开启转场动画
            startPostponedEnterTransition();
        }
    }

    /**
     * android 5转场动画.0 系统的界面
     */
    public static void start_5_0(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Pair pair = new Pair(view, mActivityOptionsCompat);
            Intent intent = new Intent(activity, ShangHaiDetailActivity.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }

}
