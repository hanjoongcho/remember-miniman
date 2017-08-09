package me.blog.korn123.rememberminiman.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.blog.korn123.commons.constants.Constants;
import me.blog.korn123.commons.utils.FontUtils;
import me.blog.korn123.rememberminiman.R;
import me.blog.korn123.rememberminiman.adapter.CharacterCardAdapter;
import me.blog.korn123.rememberminiman.model.CharacterCard;
import me.blog.korn123.rememberminiman.model.RankingCard;

/**
 * Created by hanjoong on 2017-08-06.
 */

public class RememberActivity extends AppCompatActivity {

    private StopWatch mStopWatch;
    private DatabaseReference mDatabase;
    private int correctCount = 0;
    private int mMaximumCard = 3;
    private Thread mTimer;

    @BindView(R.id.itemGrid) GridView mGridView;
    @BindView(R.id.resultMessage)  TextView mResultMessage;
    @BindView(R.id.seconds) TextView mSeconds;
    @BindView(R.id.millis) TextView mMillis;

    @BindView(R.id.header1) TextView mHeader1;
    @BindView(R.id.header2) TextView mHeader2;
    @BindView(R.id.header3) TextView mHeader3;
    @BindView(R.id.header4) TextView mHeader4;
    @BindView(R.id.header5) TextView mHeader5;
    @BindView(R.id.body1) TextView mBody1;
    @BindView(R.id.body2) TextView mBody2;
    @BindView(R.id.body3) TextView mBody3;
    @BindView(R.id.body4) TextView mBody4;
    @BindView(R.id.body5) TextView mBody5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember);
        ButterKnife.bind(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // step1 init cards
        List<CharacterCard> characterCards = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            CharacterCard characterCard = new CharacterCard(getResourceId("miniman_" + (i + 1), "raw"), "miniman_" + (i + 1));
            characterCards.add(characterCard);
        }

        // step2 mix cards
        for (int i = 0; i < 100; i++) {
            int index = (int) (Math.random() * Constants.TOTAL_CARD_COUNT);
            CharacterCard temp = characterCards.get(0);
            characterCards.set(0, characterCards.get(index));
            characterCards.set(index, temp);
        }

        mMaximumCard = getIntent().getIntExtra("maximumCard", 3);


        if (getIntent().getStringExtra("elapse1") != null) mBody2.setText(String.valueOf(getIntent().getStringExtra("elapse1")));
        if (getIntent().getStringExtra("elapse2") != null) mBody3.setText(String.valueOf(getIntent().getStringExtra("elapse2")));

        CharacterCardAdapter characterCardAdapter = new CharacterCardAdapter(this, R.layout.adapter_character_card ,characterCards);
        mGridView.setAdapter(characterCardAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView verifyResult = (TextView) view.findViewById(R.id.verifyResult);
                if (StringUtils.contains(verifyResult.getText(), "st")) {
                    return;
                }

                CharacterCard card = (CharacterCard) adapterView.getAdapter().getItem(i);
                switch (correctCount) {
                    case 0:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("1st"))) {
                            verifyResult.setText("1st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("2st"))) {
                            verifyResult.setText("2st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("3st"))) {
                            verifyResult.setText("3st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("4st"))) {
                            verifyResult.setText("4st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("5st"))) {
                            verifyResult.setText("5st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("6st"))) {
                            verifyResult.setText("6st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("7st"))) {
                            verifyResult.setText("7st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        if (StringUtils.equals(card.getInfo(), getIntent().getStringExtra("8st"))) {
                            verifyResult.setText("8st");
                            resetIncorrectCards();
                            correctCount++;
                        } else {
                            verifyResult.setText("X");
                        }
                        verifyResult.setVisibility(View.VISIBLE);
                        break;
                }

                if (correctCount == mMaximumCard) {
                    final Intent intent = new Intent(RememberActivity.this, MemorizeActivity.class);
                    String elapseTime = String.valueOf(mSeconds.getText()) + String.valueOf(mMillis.getText());
                    switch (mMaximumCard) {
                        case 3:
                            mBody2.setText(elapseTime);
                            // setting next stage max card count
                            mMaximumCard = 5;
                            intent.putExtra("elapse1", elapseTime);
                            registerElapsedTime(FirebaseAuth.getInstance().getCurrentUser(), "/ranking/stage1/", Float.valueOf(elapseTime));
                            break;
                        case 5:
                            mBody3.setText(elapseTime);
                            mMaximumCard = 8;
                            intent.putExtra("elapse1", getIntent().getStringExtra("elapse1"));
                            intent.putExtra("elapse2", elapseTime);
                            registerElapsedTime(FirebaseAuth.getInstance().getCurrentUser(), "/ranking/stage2/", Float.valueOf(elapseTime));
                            break;
                        case 8:
                            mBody4.setText(elapseTime);
                            registerElapsedTime(FirebaseAuth.getInstance().getCurrentUser(), "/ranking/stage3/", Float.valueOf(elapseTime));
                            break;
                    }

                    mTimer.interrupt();
                    float total = Float.valueOf(String.valueOf(mSeconds.getText()) + String.valueOf(mMillis.getText()));
                    if (getIntent().getStringExtra("elapse1") != null) total += Float.valueOf(getIntent().getStringExtra("elapse1"));
                    if (getIntent().getStringExtra("elapse2") != null) total += Float.valueOf(getIntent().getStringExtra("elapse2"));

                    DecimalFormat format = new DecimalFormat("###.00");

                    mBody5.setText(format.format(total));
                    intent.putExtra("maximumCard", mMaximumCard);
                    mResultMessage.setVisibility(View.VISIBLE);

                    if (correctCount < 8) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                startActivity(intent);
                                finish();
                            }
                        }).start();
                    } else {

                        mResultMessage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 70);
                        mResultMessage.setText("try again");
                        mResultMessage.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent memorizeIntent = new Intent(RememberActivity.this , MemorizeActivity.class);
                                startActivity(memorizeIntent);
                                finish();
                            }
                        });
                    }
                }
            }
        });

        Typeface typeface = FontUtils.createTypeface("OpenSans-Light.ttf", getAssets());
        FontUtils.setTypeface(this, getAssets(), mResultMessage);
        FontUtils.setTypeface(this, getAssets(), mHeader1);
        FontUtils.setTypeface(this, getAssets(), mHeader2);
        FontUtils.setTypeface(this, getAssets(), mHeader3);
        FontUtils.setTypeface(this, getAssets(), mHeader4);
        FontUtils.setTypeface(this, getAssets(), mHeader5);
        FontUtils.setTypeface(this, getAssets(), mBody1);
        FontUtils.setTypeface(this, getAssets(), mBody2);
        FontUtils.setTypeface(this, getAssets(), mBody3);
        FontUtils.setTypeface(this, getAssets(), mBody4);
        FontUtils.setTypeface(this, getAssets(), mBody5);

        mSeconds.setTypeface(typeface);
        mMillis.setTypeface(typeface);
        mStopWatch = new StopWatch();
        mTimer = new Thread(new Runnable() {
            int currentSeconds = 0;

            DecimalFormat secondsFormat = new DecimalFormat("#0");
            DecimalFormat millisFormat = new DecimalFormat("#.00");
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mStopWatch.start();
                while(correctCount < mMaximumCard) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            mSeconds.setText(secondsFormat.format(mStopWatch.getTime()/1000f));
                            float temp = Float.valueOf(millisFormat.format(mStopWatch.getTime()/1000f));
                            float temp2 = temp % 1;
                            mMillis.setText(millisFormat.format(temp2));
//                            Log.i("elap", elapseTime);
                        }
                    });

                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentSeconds++;
                }
            }
        });
        mTimer.start();
    }

    private void registerElapsedTime(FirebaseUser firebaseUser, String nodeName, float elapsedTime) {
        // if registration is possible
        if (firebaseUser != null) {
            String key = mDatabase.child("ranking").child("stage1").push().getKey();
            RankingCard rankingCard = new RankingCard(-1, firebaseUser.getEmail(), elapsedTime);
            Map<String, Object> postValues = rankingCard.toMap();
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put(nodeName + key, postValues);
            mDatabase.updateChildren(childUpdates);
        }
    }

    private void resetIncorrectCards() {
        for (int i = 0; i < mGridView.getChildCount(); i++) {
            TextView verifyResult = (TextView) mGridView.getChildAt(i).findViewById(R.id.verifyResult);
            if (StringUtils.equals(verifyResult.getText(), "X")) {
                verifyResult.setText(null);
                verifyResult.setVisibility(View.GONE);
            }
        }

    }

    public int getResourceId(String pVariableName, String pResourcename) {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
