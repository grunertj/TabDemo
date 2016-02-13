// https://www.youtube.com/watch?v=vyykjIPNBXY
package com.example.werner_jensgrunert.tabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Werner-Jens Grunert on 2/5/2016.
 */
public class Fragment1 extends Fragment {
    int jens = 0;
    TextView textView;

    public void setJens(int jens) {
        this.jens = jens;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1,container,false);

        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(Integer.toString(jens));

        return view;
    }
}
