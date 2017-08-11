package me.blog.korn123.rememberminiman.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.blog.korn123.commons.utils.FontUtils;
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
    private TabLayout mTabLayout;
    private boolean initTabView = false;

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
                    "Stage 1",
                    "Stage 2" ,
                    "Stage 3",
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
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        // Change tabview style
        mTabLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                if (!initTabView) {
                    initTabView = true;
                    Log.i("call", "here to here");
                    ViewGroup viewGroup = (ViewGroup) mTabLayout.getChildAt(0);
                    for (int k = 0; k < viewGroup.getChildCount(); k++) {
                        ViewGroup tabView = (ViewGroup) viewGroup.getChildAt(k);
                        Typeface typeface = FontUtils.createTypeface("OpenSans-Regular.ttf", getAssets());
                        for (int l = 0; l < tabView.getChildCount(); l++) {
                            if (tabView.getChildAt(l) instanceof TextView) {
                                TextView tv = (TextView) tabView.getChildAt(l);
                                tv.setAllCaps(false);
                                tv.setTypeface(typeface);
                            }
                        }
                    }
                }
            }
        });
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
