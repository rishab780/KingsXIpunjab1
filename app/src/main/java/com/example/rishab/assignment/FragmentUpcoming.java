package com.example.rishab.assignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Rishab on 21-04-2017.
 */

public class FragmentUpcoming extends Fragment {
    private ViewPager viewPager;
    private Button btnPending, btnAccepted;
    private int mode;
    private Bundle extra;

    /**
     *
     * @param i mode
     * @param extra bundle
     */
    FragmentUpcoming(final int i, final Bundle extra) {
        mode = i;
        this.extra = extra;
    }

    /**
     *
     * @param inflater inflater
     * @param container container
     * @param savedInstanceState saved instance
     * @return view
     */

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pending_accepted_layout, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.vpSwipe);
        btnPending = (Button) view.findViewById(R.id.btn_pending);
        btnAccepted = (Button) view.findViewById(R.id.btn_accepted);
        btnPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                viewPager.setCurrentItem(0);
            }
        });
        btnAccepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                viewPager.setCurrentItem(1);
            }
        });

        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return new FragmentAcceptedMissed(0, extra);
                } else {
                    return new FragmentAcceptedMissed(1, extra);
                }

            }

        };
        /**
         *  page color selector
         */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {
                    btnPending.setBackgroundResource(R.color.colorPrimaryDark);
                    btnAccepted.setBackgroundResource(R.color.colorPrimary);
                } else {
                    btnPending.setBackgroundResource(R.color.colorPrimary);
                    btnAccepted.setBackgroundResource(R.color.colorPrimaryDark);
                }

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        viewPager.setAdapter(fragmentStatePagerAdapter);
        return view;
    }
}
