package com.glencconnnect.shumbamoneweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ///handler to simulate delay and switch from splashscreen into MainActivity
        handler.postDelayed(() ->
                startActivity(new Intent(SplashScreenActivity.this,MainActivity.class)
                ),3000);
    }
}