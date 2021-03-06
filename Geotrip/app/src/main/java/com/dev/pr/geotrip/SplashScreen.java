package com.dev.pr.geotrip;

/**
 * Created by vermel on 20/12/14.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;


public class SplashScreen extends Activity {

    private static final int STOPSPLASH = 10;
    private static final long SPLASHTIME = 1000;

    Handler splashHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STOPSPLASH:
                    Intent intent = new Intent(SplashScreen.this, Connexion.class);
                    finish();
                    startActivity(intent);
                    break;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);
        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
    }
}
