package com.buildwithsiele.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*method to set splash screen in full screen display**/
        /*getWindow()
                .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_splash_screen);

        int SPLASH_SCREEN_TIME_OUT = 2000;
        new Handler().postDelayed(() -> {
            Intent nextActivity = new Intent(SplashScreenActivity.this, LeaderBoardActivity.class);

            /*switching to next activity*/
            startActivity(nextActivity);
    /*        closing splashscreen activity*/
            finish();
        }, SPLASH_SCREEN_TIME_OUT);

    }
}