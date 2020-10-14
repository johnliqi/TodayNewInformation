package com.candymobi.todaynewinformation;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.candymobi.todaynewinformation.Utils.CountTimer;
import com.candymobi.todaynewinformation.Views.FullScreenVideoView;

public class SplashActivity extends AppCompatActivity {
    private FullScreenVideoView mVideoView;
    TextView mSkipTextView;
    CountTimer countTimer;
    String uri = "android.resource://com.candymobi.todaynewinformation" + "/" + R.raw.splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mVideoView = findViewById(R.id.video_view);
        mSkipTextView = findViewById(R.id.tv_skip);
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
         countTimer = new CountTimer(5, new CountTimer.ICountHandler() {
            @Override
            public void onTicker(int time) {
                mSkipTextView.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mSkipTextView.setText("跳过");
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        countTimer.start();

    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {//横屏
//
//
//        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {//竖屏
//
//
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countTimer.stop();
    }
}
