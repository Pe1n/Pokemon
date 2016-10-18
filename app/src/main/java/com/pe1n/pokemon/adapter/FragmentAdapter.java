package com.pe1n.pokemon.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentlist;

    private String[] tabs;

    public FragmentAdapter(FragmentManager fm,List<Fragment> fragmentlist,String[] tabs) {
        super(fm);
        this.fragmentlist = fragmentlist;
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

}
