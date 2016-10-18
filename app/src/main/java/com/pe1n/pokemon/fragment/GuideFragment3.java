package com.pe1n.pokemon.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pe1n.pokemon.R;
import com.pe1n.pokemon.activity.GuideActivity;
import com.pe1n.pokemon.activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment3 extends Fragment {

    private Button button;

    public GuideFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guide_fragment3, container, false);
        button = (Button) view.findViewById(R.id.btn_guide);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuideActivity activity = (GuideActivity) getActivity();
                Intent intent = new Intent(activity,LoginActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });

        return view;
    }

}
