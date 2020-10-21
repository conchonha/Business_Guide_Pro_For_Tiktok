package com.teamwork.businessguideprofortiktok.src.resource.adapters.introduce_adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment.FragmentSlider1;
import com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment.FragmentSlider2;
import com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment.FragmentSlider0;

import java.util.ArrayList;

//adapter introduce viewpager
public class IntroduceAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>arrayFragment = new ArrayList<>();

    // create constructer viewpager
    public IntroduceAdapter(@NonNull FragmentManager fm) {
        super(fm);
        arrayFragment.add(new FragmentSlider0());
        arrayFragment.add(new FragmentSlider1());
        arrayFragment.add(new FragmentSlider2());

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
