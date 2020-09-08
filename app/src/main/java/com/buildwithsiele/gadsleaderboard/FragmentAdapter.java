package com.buildwithsiele.gadsleaderboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

class FragmentAdapter extends FragmentPagerAdapter {
    TabLayout mTabLayout;
    Context context;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, Context context, TabLayout mTabLayout) {
        super(fm, behavior);
        this.mTabLayout = mTabLayout;
        this.context = context;

    }

    /*public FragmentAdapter(@NonNull FragmentManager fm, Context context, TabLayout mTabLayout) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.mTabLayout = mTabLayout;
    }
*/
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0){
            fragment = new LearningLeadersFragment();
        }
        else if (position == 1){
            fragment = new SkillIqFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0){
            title = "Learning Leaders";
        }
        else if (position == 1){
            title = "Skill IQ Leaders";
        }
        return title;


    }

    @Override
    public int getCount() {
        return 2;
    }
}
