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
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
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

    final String FRAGMENT_1 = "STAGE 1";
    final String FRAGMENT_2 = "STAGE 2";
    final String FRAGMENT_3 = "STAGE 3";
    final String FRAGMENT_4 = "TOTAL";

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.navigation1) ImageView mNavigation1;
    @BindView(R.id.navigation2) ImageView mNavigation2;
    @BindView(R.id.navigation3) ImageView mNavigation3;
    @BindView(R.id.navigation4) ImageView mNavigation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        ButterKnife.bind(this);

        FontUtils.setTypeface(this, getAssets(), mTitle);
        mTitle.setText(FRAGMENT_1);

        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new RankingT1Fragment(),
                    new RankingT2Fragment(),
                    new RankingT3Fragment(),
                    new RankingT4Fragment(),
            };
            private final String[] mFragmentNames = new String[] {
                    FRAGMENT_1,
                    FRAGMENT_2,
                    FRAGMENT_3,
                    FRAGMENT_4
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

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initNavigationIcon();
                switch (position) {
                    case 0:
                        mTitle.setText(FRAGMENT_1);
                        mNavigation1.setImageResource(R.drawable.ic_circle_selected);
                        break;
                    case 1:
                        mTitle.setText(FRAGMENT_2);
                        mNavigation2.setImageResource(R.drawable.ic_circle_selected);
                        break;
                    case 2:
                        mTitle.setText(FRAGMENT_3);
                        mNavigation3.setImageResource(R.drawable.ic_circle_selected);
                        break;
                    case 3:
                        mTitle.setText(FRAGMENT_4);
                        mNavigation4.setImageResource(R.drawable.ic_circle_selected);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initNavigationIcon() {
        mNavigation1.setImageResource(R.drawable.ic_circle_default);
        mNavigation2.setImageResource(R.drawable.ic_circle_default);
        mNavigation3.setImageResource(R.drawable.ic_circle_default);
        mNavigation4.setImageResource(R.drawable.ic_circle_default);
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
