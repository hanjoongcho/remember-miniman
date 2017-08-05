package me.blog.korn123.rememberminiman;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.blog.korn123.commons.constants.Constants;
import me.blog.korn123.commons.utils.CommonUtils;
import me.blog.korn123.commons.utils.FontUtils;

/**
 * Created by hanjoong on 2017-08-06.
 */

public class MemorizeActivity extends AppCompatActivity {

    private List<String> mCardIds;
    private int mMaximumCard = 3;
    private boolean mInitScreen = false;

    @BindView(R.id.mainScreen) LinearLayout mMainScreen;
    @BindView(R.id.infoScreen) LinearLayout mInfoScreen;
    @BindView(R.id.pathViewContainer) LinearLayout mPathViewContainer;

    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.guideMessage) TextView mGuideMessage;
    @BindView(R.id.confirm) TextView mConfirm;
    @BindView(R.id.minimanSequence) TextView mMinimanSequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize);
        ButterKnife.bind(this);

        // step1 init cards
        mCardIds = new ArrayList<>();
        for (int i = 0; i < Constants.TOTAL_CARD_COUNT; i++) {
            mCardIds.add("miniman_" + (i + 1));
        }

        // step2 mix cards
        for (int i = 0; i < 100; i++) {
            int index = (int) (Math.random() * Constants.TOTAL_CARD_COUNT);
            String temp = mCardIds.get(0);
            mCardIds.set(0, mCardIds.get(index));
            mCardIds.set(index, temp);
        }

        // step3 setting stage info
        mMaximumCard = getIntent().getIntExtra("maximumCard", 3);
        String title = null;
        String message = null;
        switch (mMaximumCard) {
            case 3:
                title = "STAGE 1";
                message = getString(R.string.stage_1_guide_message);
                break;
            case 5:
                title = "STAGE 2";
                message = getString(R.string.stage_2_guide_message);
                break;
            case 8:
                title = "STAGE 3";
                message = getString(R.string.stage_3_guide_message);
                break;
        }

        mTitle.setText(title);
        mGuideMessage.setText(message);
        FontUtils.setTypeface(this, getAssets(), mTitle);
        FontUtils.setTypeface(this, getAssets(), mMinimanSequence);
        FontUtils.setTypeface(this, getAssets(), mGuideMessage);
        FontUtils.setTypeface(this, getAssets(), mConfirm);

        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainScreen.setVisibility(View.VISIBLE);
                mInfoScreen.setVisibility(View.GONE);
                new IconRenderThread(MemorizeActivity.this, 0).start();
            }
        });
    }


    public int getResourceId(String pVariableName, String pResourcename) {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    class IconRenderThread extends Thread {

        Context context;
        int iconIndex = -1;

        IconRenderThread (Context context, int iconIndex) {
            this.context = context;
            this.iconIndex = iconIndex;
        }

        @Override
        public void run() {
            super.run();
            try {
                if (mInitScreen) {
                    Thread.sleep(1500);
                } else {
                    mInitScreen = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            mPathView.clearAnimation();

            final PathView pathView = new PathView(context);
            pathView.setPathColor(Color.parseColor("#000000"));
            pathView.setPathWidth(CommonUtils.dpToPixel(context, 1));
//            pathView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            pathView.setLayoutParams(new ViewGroup.LayoutParams(CommonUtils.dpToPixel(context, 145), CommonUtils.dpToPixel(context, 150)));
            pathView.setSvgResource(getResourceId(mCardIds.get(iconIndex), "raw"));
//            pathView.useNaturalColors();
            pathView.setFillAfter(true);
            final PathView.AnimatorBuilder animatorBuilder;
            animatorBuilder = pathView.getPathAnimator()
//                    .delay(500)
                    .duration(700)
                    .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                        @Override
                        public void onAnimationEnd() {
                            new IconRenderThread(context, iconIndex + 1).start();
                        }
                    })
                    .interpolator(new AccelerateDecelerateInterpolator());
            if (iconIndex < mMaximumCard) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (mPathViewContainer.getChildCount() > 0) {
                            mPathViewContainer.removeViewAt(0);
                        }
                        mMinimanSequence.setText(String.valueOf(iconIndex + 1));
                        mPathViewContainer.addView(pathView);
                        animatorBuilder.start();
                    }
                });
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MemorizeActivity.this, RememberActivity.class);
                        intent.putExtra("maximumCard", mMaximumCard);
                        intent.putExtra("1st", mCardIds.get(0));
                        intent.putExtra("2st", mCardIds.get(1));
                        intent.putExtra("3st", mCardIds.get(2));

                        if (mMaximumCard >= 5) {
                            intent.putExtra("4st", mCardIds.get(3));
                            intent.putExtra("5st", mCardIds.get(4));
                            intent.putExtra("elapse1", getIntent().getStringExtra("elapse1"));
                        }

                        if (mMaximumCard >= 8) {
                            intent.putExtra("6st", mCardIds.get(5));
                            intent.putExtra("7st", mCardIds.get(6));
                            intent.putExtra("8st", mCardIds.get(7));
                            intent.putExtra("elapse1", getIntent().getStringExtra("elapse1"));
                            intent.putExtra("elapse2", getIntent().getStringExtra("elapse2"));
                        }

                        startActivity(intent);
                        finish();
                    }
                });

            }
        }
    }

}
