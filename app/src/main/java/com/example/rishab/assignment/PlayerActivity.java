package com.example.rishab.assignment;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

/**
 * gfhf
 */
public class PlayerActivity extends AppCompatActivity {
    private Button btnUpcomming, btnpassed;
    private ViewPager viewPager;
    private Bundle extras;
    /**
     *
     * @param savedInstanceState saved instance
     */
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        viewPager = (ViewPager) findViewById(R.id.vpSwipe1);
        btnUpcomming = (Button) findViewById(R.id.btn_upcoming);
        btnpassed = (Button) findViewById(R.id.btn_past);
        extras = getIntent().getExtras();

        btnUpcomming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                viewPager.setCurrentItem(0);
            }
        });
        btnpassed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                viewPager.setCurrentItem(1);
            }
        });

        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return new FragmentUpcoming(0, extras);
                } else {
                    return new FragmentUpcoming(1, extras);
                }

            }

        };
        /**
         *  page color selector
         */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                if (position == 0) {
                    btnUpcomming.setBackgroundResource(R.color.colorPrimaryDark);
                    btnpassed.setBackgroundResource(R.color.colorPrimary);
                } else {
                    btnUpcomming.setBackgroundResource(R.color.colorPrimary);
                    btnpassed.setBackgroundResource(R.color.colorPrimaryDark);
                }
            }

            @Override
            public void onPageSelected(final int position) {

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        viewPager.setAdapter(fragmentStatePagerAdapter);

    }

}
