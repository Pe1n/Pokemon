package com.pe1n.pokemon.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pe1n.pokemon.R;
import com.pe1n.pokemon.adapter.FragmentAdapter;
import com.pe1n.pokemon.javabean.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment1 extends Fragment {

    public static final String[] TAB_LIST = {"精灵","美图"};

    private List<Fragment> fragmentList;

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private View view;

    private FragmentAdapter fragmentAdapter;

    private MainInnerFragment1 innerFragment1;
    private MainInnerFragment2 innerFragment2;

    public MainFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_main_fragment1, container, false);

        initData();

        initViewPager();

        initTabLayout();

        return view;
    }

    private void initTabLayout() {

        tabLayout = (TabLayout) view.findViewById(R.id.layout_tab);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initViewPager() {

        FragmentManager fm = getChildFragmentManager();
        viewPager =  (ViewPager) view.findViewById(R.id.vp_main);
        fragmentAdapter = new FragmentAdapter(fm,fragmentList,TAB_LIST);
        viewPager.setAdapter(fragmentAdapter);

    }

    private void initData() {

        fragmentList = new ArrayList<>();
        innerFragment1 = new MainInnerFragment1();
        innerFragment2 = new MainInnerFragment2();
        fragmentList.add(innerFragment1);
        fragmentList.add(innerFragment2);

    }

}
