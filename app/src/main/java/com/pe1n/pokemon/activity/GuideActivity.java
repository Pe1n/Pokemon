package com.pe1n.pokemon.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pe1n.pokemon.R;
import com.pe1n.pokemon.adapter.GuideAdapter;
import com.pe1n.pokemon.fragment.GuideFragment1;
import com.pe1n.pokemon.fragment.GuideFragment2;
import com.pe1n.pokemon.fragment.GuideFragment3;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private List<Fragment> fragmentList;

    private GuideAdapter guideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initData();

        initViewPager();

    }

    private void initViewPager() {

        FragmentManager fm = getSupportFragmentManager();
        guideAdapter = new GuideAdapter(fm,fragmentList);
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        viewPager.setAdapter(guideAdapter);

    }

    private void initData() {

        fragmentList = new ArrayList<>();

        GuideFragment1 guideFragment1 = new GuideFragment1();
        GuideFragment2 guideFragment2 = new GuideFragment2();
        GuideFragment3 guideFragment3 = new GuideFragment3();

        fragmentList.add(guideFragment1);
        fragmentList.add(guideFragment2);
        fragmentList.add(guideFragment3);

    }
}
