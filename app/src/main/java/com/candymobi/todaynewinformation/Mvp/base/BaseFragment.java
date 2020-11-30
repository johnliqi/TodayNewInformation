package com.candymobi.todaynewinformation.Mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.candymobi.todaynewinformation.Mvp.view.LifeCircleMvpFragment;
import com.candymobi.todaynewinformation.R;

import java.util.zip.Inflater;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment {
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
     this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewInject annotation = getClass().getAnnotation(ViewInject.class);
        View mView = null;
        if (annotation != null) {
            int mainLayoutId = annotation.getMainLayoutId();
            if (mainLayoutId > 0) {
                mView = initFragmentView(inflater,mainLayoutId);

                bindView(mView);
                afterBindView();
            } else {
                throw new RuntimeException("mainLayoutId <0");
            }
        } else {
            throw new RuntimeException("annotation =null");
        }
        return mView;

    }

    private View initFragmentView(LayoutInflater inflater ,int mainLayoutId) {
        return inflater.inflate(mainLayoutId, null);
    }




    protected abstract void afterBindView();

    //View的依赖注入绑定
    private void bindView(View mView ) {
        ButterKnife.bind(this,mView);
    }
}
