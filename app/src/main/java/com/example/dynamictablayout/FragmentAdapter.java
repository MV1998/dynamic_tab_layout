package com.example.dynamictablayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public FragmentAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        return FragmentDynamic.addfrag(position);
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }

}
