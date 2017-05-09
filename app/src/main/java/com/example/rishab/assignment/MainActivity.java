package com.example.rishab.assignment;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

/**
 * created by Rishab
 */
public class MainActivity extends BaseActivity {
    static final int SPLASH_DISPLAY_LENGTH = 2000;


    /**
     *
     * @param savedInstanceState instance
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}
