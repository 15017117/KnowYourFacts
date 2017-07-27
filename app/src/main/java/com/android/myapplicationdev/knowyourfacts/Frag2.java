package com.android.myapplicationdev.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {
Button btnChangeColor;

    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container,false);
    btnChangeColor = (Button)view.findViewById(R.id.btnChangeColor);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] colorArray = {"#FF4A7B","#646ACE","#BEC2FF", "#C5C45F", "#F0B761", "#FF8130"};
            Random random = new Random();
            int index = random.nextInt(colorArray.length);
            String color = colorArray[index];
            getView().setBackgroundColor(Color.parseColor(color));

        }
    });
        return view;
}
}
