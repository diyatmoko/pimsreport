package com.firstresources.pimsfa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 13/05/2019
 */
public class SplashActivity extends AppCompatActivity {
    private int loading=1000;

    //2000 = 2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent =new Intent(getBaseContext(), StartActivity.class);
                startActivity(intent);
                finish();

            }
        },loading);
    }
}