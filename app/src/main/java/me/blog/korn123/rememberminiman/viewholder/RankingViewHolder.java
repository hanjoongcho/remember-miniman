package me.blog.korn123.rememberminiman.viewholder;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    public RankingViewHolder(View itemView) {
        super(itemView);

        rankingNoView = (TextView) itemView.findViewById(R.id.rankingNo);
        userNameView = (TextView) itemView.findViewById(R.id.userName);
        recordTimeView = (TextView) itemView.findViewById(R.id.recordTime);
    }

    public void bindToCard(RankingCard rankingCard, int position, Context context, AssetManager assetManager) {
//        FontUtils.setTypeface(context, assetManager, rankingNoView);
//        FontUtils.setTypeface(context, assetManager, userNameView);
//        FontUtils.setTypeface(context, assetManager, recordTimeView);
        rankingNoView.setText(String.valueOf(position + 1));
        userNameView.setText(String.valueOf(rankingCard.userName));
        recordTimeView.setText("elapsed time: " + String.valueOf(rankingCard.recordTime) + "s");
    }
}
