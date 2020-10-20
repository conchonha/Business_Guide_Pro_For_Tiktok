package com.teamwork.businessguideprofortiktok.src.resource.adapters.introduce_adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment.Introduction;
import com.teamwork.businessguideprofortiktok.src.resource.fragments.register_fragment.Register;
import com.teamwork.businessguideprofortiktok.src.resource.fragments.login_fragment.Login;

import java.util.ArrayList;

//adapter introduce viewpager
public class IntroduceAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>arrayFragment = new ArrayList<>();

    // create constructer viewpager
    public IntroduceAdapter(@NonNull FragmentManager fm) {
        super(fm);
        arrayFragment.add(new Introduction());
        arrayFragment.add(new Register());
        arrayFragment.add(new Login());
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
