package com.undp.aep.ui.Activity.Start;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SplashActivity extends AppCompatActivity {
    public  int TIME=3000;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        ImageView IB = findViewById(R.id.image);
        //getScreenWidth();
        IB.getLayoutParams().width= (int) Resources.getSystem().getDisplayMetrics().widthPixels;
        IB.getLayoutParams().height= (int) Resources.getSystem().getDisplayMetrics().widthPixels;

        handler = new Handler();
    }
    Handler handler;
    @Override
    protected void onResume() {
        super.onResume();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(TIME);
                    handler.post(new Runnable() {
                        public void run() {
                            goToNextScreen();
                        }
                    });
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();
    }
    protected void goToNextScreen() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        SplashActivity.this.finish();
    }
    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }


}