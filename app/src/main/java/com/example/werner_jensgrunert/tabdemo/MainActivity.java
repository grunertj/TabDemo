// https://www.youtube.com/watch?v=-a2jJ92bmzw
// https://www.youtube.com/watch?v=RnM8aTof9V4
// http://www.amazon.com/gp/product/1449362184
// https://www.youtube.com/watch?v=sPvCEsGm8us
// http://stackoverflow.com/questions/19873063/handler-is-abstract-cannot-be-instantiated
// http://www.mopri.de/2010/timertask-bad-do-it-the-android-way-use-a-handler/
// http://android-er.blogspot.it/2013/12/example-of-using-timer-and-timertask-on.html

package com.example.werner_jensgrunert.tabdemo;

import android.os.CountDownTimer;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    static int klaus = 10;
    static Fragment1 f1;
    static Fragment2 f2;
    static Fragment3 f3;
    TextView textview;
    Handler handler;
    Runnable runnable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        handler.postDelayed(runnable, 100);

        textview = (TextView) findViewById(R.id.textView3);

        f2 = new Fragment2();
        f2.setRetainInstance(true);

        f1 = new Fragment1();
        f1.setRetainInstance(true);

        f3 = new Fragment3();
        f3.setRetainInstance(true);
/*
        f1.setRetainInstance(true);
        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.add(R.id.fragment, f1);
        FT.addToBackStack("f1");
        FT.commit();
*/

        /*
        f2.setRetainInstance(true);
        FragmentTransaction FT1 = getSupportFragmentManager().beginTransaction();
        FT1.add(R.id.fragment2, f2);
        FT1.addToBackStack("f2");
        FT1.commit();
*/
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        // up to here it's already working with swipes
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                f2.setTime("seconds remaining: " + millisUntilFinished / 1000);

                textview.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                f2.setTime("finished");
                textview.setText("fine");

            }
        }.start();


    }

    private class CustomAdapter extends FragmentStatePagerAdapter {
        private String fragments [] = {"Fragment 1", "Fragment 2", "Fragment 3"};
        public CustomAdapter(FragmentManager fm, Context applicationContext) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return f2;
                case 1:
                    return f1;
                case 2:
                    return f3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        f1.setJens(klaus);
        klaus++;
    }
}
