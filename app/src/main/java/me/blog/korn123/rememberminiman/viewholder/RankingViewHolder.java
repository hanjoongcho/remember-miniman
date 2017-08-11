package me.blog.korn123.rememberminiman.viewholder;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.blog.korn123.commons.utils.FontUtils;
import me.blog.korn123.rememberminiman.R;
import me.blog.korn123.rememberminiman.model.RankingCard;

/**
 * Created by CHO HANJOONG on 2017-08-09.
 */

public class RankingViewHolder extends RecyclerView.ViewHolder{

    public TextView rankingNoView;
    public TextView userNameView;
    public TextView recordTimeView;
    public ImageView imageView;

    public RankingViewHolder(View itemView) {
        super(itemView);

        rankingNoView = (TextView) itemView.findViewById(R.id.rankingNo);
        userNameView = (TextView) itemView.findViewById(R.id.userName);
        recordTimeView = (TextView) itemView.findViewById(R.id.recordTime);
        imageView = (ImageView) itemView.findViewById(R.id.medal);
    }

    public void bindToCard(RankingCard rankingCard, int position, Context context, AssetManager assetManager) {
        Typeface typeface = FontUtils.createTypeface("OpenSans-Regular.ttf", assetManager);
        rankingNoView.setTypeface(typeface);
        userNameView.setTypeface(typeface);
        recordTimeView.setTypeface(typeface);
//        FontUtils.setTypeface(context, assetManager, rankingNoView);
//        FontUtils.setTypeface(context, assetManager, userNameView);
//        FontUtils.setTypeface(context, assetManager, recordTimeView);
        rankingNoView.setText(String.valueOf(position + 1));
        userNameView.setText(String.valueOf(rankingCard.userName));
        recordTimeView.setText("elapsed time: " + String.valueOf(rankingCard.recordTime) + "s");
        switch (position) {
            case 0:
                imageView.setImageResource(R.drawable.ic_gold_medal);
                break;
            case 1:
                imageView.setImageResource(R.drawable.ic_silver_medal);
                break;
            case 2:
                imageView.setImageResource(R.drawable.ic_bronze_medal);
                break;
            default:
                imageView.setImageResource(0);
                break;
        }
    }
}
