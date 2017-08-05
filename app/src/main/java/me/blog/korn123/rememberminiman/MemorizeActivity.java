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
import me.blog.korn123.commons.utils.CommonUtils;
import me.blog.korn123.commons.utils.FontUtils;

/**
 * Created by hanjoong on 2017-08-06.
 */

public class MemorizeActivity extends AppCompatActivity {

    final int TOTAL_CARD_COUNT = 20;
    int mMaximumCard = 3;
    boolean mInitScreen = false;
    List<String> cardIdList;

    @BindView(R.id.mainScreen) LinearLayout mMainScreen;
    @BindView(R.id.infoScreen) LinearLayout mInfoScreen;
    @BindView(R.id.startMessage) TextView mStartMessage;
    @BindView(R.id.confirm) TextView mConfirm;
    @BindView(R.id.infoMessage) TextView mInfoMessage;
    @BindView(R.id.container) LinearLayout mContainer;
    @BindView(R.id.title) TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize);
        ButterKnife.bind(this);

        // step1 카드초기화
        cardIdList = new ArrayList<>();
        for (int i = 0; i < TOTAL_CARD_COUNT; i++) {
            cardIdList.add("miniman_" + (i + 1));
        }

        // step1 카드섞기
        for (int i = 0; i < 100; i++) {
            int index = (int) (Math.random() * TOTAL_CARD_COUNT);
            String temp = cardIdList.get(0);
            cardIdList.set(0, cardIdList.get(index));
            cardIdList.set(index, temp);
        }

        // step3 스테이지 설정
        mMaximumCard = getIntent().getIntExtra("maximumCard", 3);
        String title = null;
        String message = null;
        switch (mMaximumCard) {
            case 3:
                title = "STAGE 1";
                message = "연속되는 3개의 캐릭터를 기억하세요.";
                break;
            case 5:
                title = "STAGE 2";
                message = "연속되는 5개의 캐릭터를 기억하세요.";
                break;
            case 8:
                title = "STAGE 3";
                message = "연속되는 8개의 캐릭터를 기억하세요.";
                break;
        }
        mTitle.setText(title);
        mStartMessage.setText(message);
        FontUtils.setTypeface(this, getAssets(), mTitle);
        FontUtils.setTypeface(this, getAssets(), mInfoMessage);
        FontUtils.setTypeface(this, getAssets(), mStartMessage);
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


    public int getResourceId(String pVariableName, String pResourcename)
    {
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
            pathView.setSvgResource(getResourceId(cardIdList.get(iconIndex), "raw"));
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
                        if (mContainer.getChildCount() > 0) {
                            mContainer.removeViewAt(0);
                        }
                        mInfoMessage.setText(String.valueOf(iconIndex + 1));
                        mContainer.addView(pathView);
                        animatorBuilder.start();
                    }
                });
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
//                        Intent intent = new Intent(MemorizeActivity.this, ItemGridActivity.class);
//                        intent.putExtra("maximumCard", mMaximumCard);
//                        intent.putExtra("1st", cardIdList.get(0));
//                        intent.putExtra("2st", cardIdList.get(1));
//                        intent.putExtra("3st", cardIdList.get(2));
//
//                        if (mMaximumCard >= 5) {
//                            intent.putExtra("4st", cardIdList.get(3));
//                            intent.putExtra("5st", cardIdList.get(4));
//                            intent.putExtra("elapse1", getIntent().getStringExtra("elapse1"));
//                        }
//
//                        if (mMaximumCard >= 8) {
//                            intent.putExtra("6st", cardIdList.get(5));
//                            intent.putExtra("7st", cardIdList.get(6));
//                            intent.putExtra("8st", cardIdList.get(7));
//                            intent.putExtra("elapse1", getIntent().getStringExtra("elapse1"));
//                            intent.putExtra("elapse2", getIntent().getStringExtra("elapse2"));
//                        }
//
//                        startActivity(intent);
//                        finish();
                    }
                });

            }
        }
    }

}
