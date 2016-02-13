// http://tamsler.blogspot.it/2011/11/android-viewpager-and-fragments-part-ii.html

package com.example.werner_jensgrunert.tabdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Werner-Jens Grunert on 2/5/2016.
 */
public class Fragment2 extends Fragment {
    String jens = "Start";
    private static TextView textView;

    public void setTime(String jens) {
        this.jens = jens;
        if (textView != null) {
            textView.setText(jens);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2, container, false);

        textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText(jens);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.setText(jens);
    }

}
