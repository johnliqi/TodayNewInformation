package com.candymobi.todaynewinformation.Mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.candymobi.todaynewinformation.Mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

public abstract  class BaseActivity extends LifeCircleMvpActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayoutId = annotation.getMainLayoutId();
            if (mainLayoutId > 0) {
                setContentView(mainLayoutId);
                bindView();
               afterBindView();
            } else {
                throw new RuntimeException("mainLayoutId <0");
            }
        } else {
            throw new RuntimeException("annotation =null");
        }
    }

    protected abstract void afterBindView();

    //View的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);
    }
}
