package me.blog.korn123.rememberminiman.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.blog.korn123.commons.utils.FontUtils;
import me.blog.korn123.rememberminiman.R;

/**
 * Created by hanjoong on 2017-08-06.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.miniman) PathView mMiniman;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.start) TextView mStart;
    @BindView(R.id.license) TextView mLicense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FontUtils.setTypeface(this, getAssets(), mTitle);
        FontUtils.setTypeface(this, getAssets(), mStart);
        FontUtils.setTypeface(this, getAssets(), mLicense);

        mMiniman.useNaturalColors();
        mMiniman.setFillAfter(true);
        mMiniman.getPathAnimator()
                .delay(500)
                .duration(700)
                .interpolator(new AccelerateDecelerateInterpolator()).start();
    }

    @OnClick({R.id.start, R.id.license})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                Intent memorizeIntent = new Intent(this, MemorizeActivity.class);
                startActivity(memorizeIntent);
                finish();
                break;
            case R.id.license:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hanjoongcho/remember-miniman/blob/master/LICENSE.md"));
                startActivity(browserIntent);
                break;
        }
    }

}
