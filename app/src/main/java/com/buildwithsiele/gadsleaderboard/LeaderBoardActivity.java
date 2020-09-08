package com.buildwithsiele.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.icu.lang.UScript;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class LeaderBoardActivity extends AppCompatActivity {

    public static int OFFSCREEN_PAGE_LIMIT = 2;
    Toolbar mToolbar;
    TabLayout mTabLayout;
    Button mButton;
    Context mContext;
    private  static ViewPager sViewPager;
     FragmentAdapter mFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        mToolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tab);
        mButton = findViewById(R.id.btn_submit);
        sViewPager = findViewById(R.id.viewpager);

        sViewPager.setOffscreenPageLimit(OFFSCREEN_PAGE_LIMIT);


        setTabFragments();

        assert getSupportActionBar() != null;
        setSupportActionBar(mToolbar);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitActivity = new Intent(LeaderBoardActivity.this, SubmitActivity.class);
                startActivity(submitActivity);
            }
        });
    }

    private void setTabFragments() {
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),1,mContext,mTabLayout);
        sViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(sViewPager);
    }
}