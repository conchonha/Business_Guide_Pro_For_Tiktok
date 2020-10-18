package com.teamwork.cookiesproject.src.resource.adapters.introduce_adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.teamwork.cookiesproject.src.resource.fragments.introduce_fragment.introduce_fragment1.IntroduceFragment1;
import com.teamwork.cookiesproject.src.resource.fragments.introduce_fragment.introduce_fragment2.IntroduceFragment2;
import com.teamwork.cookiesproject.src.resource.fragments.introduce_fragment.introduce_fragment3.IntroduceFragment3;

import java.util.ArrayList;

//adapter introduce viewpager
public class IntroduceAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>arrayFragment = new ArrayList<>();

    // create constructer viewpager
    public IntroduceAdapter(@NonNull FragmentManager fm) {
        super(fm);
        arrayFragment.add(new IntroduceFragment1());
        arrayFragment.add(new IntroduceFragment2());
        arrayFragment.add(new IntroduceFragment3());
    }

    @NonNull
    @Override
    //retunr item fragment
    public Fragment getItem(int position) {
        return arrayFragment.get(position);
    }

    @Override
    //count number arrayfragment
    public int getCount() {
        return arrayFragment.size();
    }
}
