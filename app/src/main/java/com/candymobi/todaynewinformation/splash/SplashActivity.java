package com.candymobi.todaynewinformation.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.candymobi.todaynewinformation.Mvp.base.BaseActivity;
import com.candymobi.todaynewinformation.main.MainActivity;
import com.candymobi.todaynewinformation.R;
import com.candymobi.todaynewinformation.Mvp.base.ViewInject;

import butterknife.BindView;

@ViewInject(getMainLayoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.Iview {
    @BindView(R.id.video_view)
    FullScreenVideoView mVideoView;
    @BindView(R.id.tv_skip)
    TextView mSkipTextView;
    CountTimerTask countTimer;
    String uri = "android.resource://com.candymobi.todaynewinformation" + "/" + R.raw.splash;
    ISplashActivityContract.IPresenter splashTimerPresenter;



    @Override
    protected void afterBindView() {
        initTimerPresenter();
        initVideo();
        initListener();
    }

    private void initTimerPresenter() {
        splashTimerPresenter = new SplashTimerPresenter(this);
        splashTimerPresenter.initTimer();
    }


    private void initListener() {
        mSkipTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initVideo() {
        mVideoView.setVideoURI(Uri.parse(uri));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoView.start();
            }
        });
    }



    @Override
    public void setTextCountTimer(String time) {
        mSkipTextView.setText(time);
    }

}
