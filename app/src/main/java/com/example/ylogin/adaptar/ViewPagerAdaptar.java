package com.example.ylogin.adaptar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdaptar extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> titlelist = new ArrayList<>();

    public ViewPagerAdaptar(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentArrayList.add(fragment);
        titlelist.add(title);
    }
    @Override
    public String getPageTitle(int position) {
        return titlelist.get(position);
    }
}
