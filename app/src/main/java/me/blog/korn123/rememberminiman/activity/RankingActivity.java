package me.blog.korn123.rememberminiman.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.blog.korn123.rememberminiman.R;
import me.blog.korn123.rememberminiman.fragment.RankingT1Fragment;
import me.blog.korn123.rememberminiman.fragment.RankingT2Fragment;
import me.blog.korn123.rememberminiman.fragment.RankingT3Fragment;
import me.blog.korn123.rememberminiman.fragment.RankingT4Fragment;

/**
 * Created by CHO HANJOONG on 2017-08-09.
 */

public class RankingActivity extends BaseActivity {

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        ButterKnife.bind(this);

        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new RankingT1Fragment(),
                    new RankingT2Fragment(),
                    new RankingT3Fragment(),
                    new RankingT4Fragment(),
            };
            private final String[] mFragmentNames = new String[] {
                    "Stage1",
                    "Stage2" ,
                    "Stage3",
                    "Total"
            };
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }
            @Override
            public int getCount() {
                return mFragments.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @OnClick({R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }

}
