// http://tamsler.blogspot.it/2011/11/android-viewpager-and-fragments-part-ii.html

package com.example.werner_jensgrunert.tabdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Werner-Jens Grunert on 2/5/2016.
 */
public class Fragment3 extends Fragment {
    Calendar mCalendar;

    private Runnable mTicker;
    private Handler mHandler;

    TextView mClock;
    static int i = 0;

    String mFormat;
    SimpleDateFormat simpleDateFormat;

    private boolean mClockStopped = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.frag3, container, false);

        mClock = (TextView) view.findViewById(R.id.clock);
        mClock.setText("Jens");

        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        mCalendar = Calendar.getInstance();

        mHandler = new Handler();

        mTicker = new Runnable() {
            public void run() {
                if(mClockStopped) return;
                mCalendar.setTimeInMillis(System.currentTimeMillis());
                mClock.setText(simpleDateFormat.format(mCalendar.getTime()));
                // mClock.invalidate();
                // long now = SystemClock.uptimeMillis();
                // long next = now + (1000 - now % 1000);
                // mHandler.postAtTime(mTicker, next);
                mHandler.postDelayed(mTicker,1000);
            }
        };
        mTicker.run();


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mClock.setText("Jens onResume");

        //mClockStopped = false;
        //    textView.setText(jens);
    }

    @Override
    public void onPause() {
        super.onPause();
        mClock.setText("Jens onPause");

        //mClockStopped = true;
    }
}
