package me.blog.korn123.rememberminiman.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;

import java.util.List;

import me.blog.korn123.commons.utils.CommonUtils;
import me.blog.korn123.commons.utils.FontUtils;
import me.blog.korn123.rememberminiman.R;
import me.blog.korn123.rememberminiman.model.CharacterCard;

/**
 * Created by hanjoong on 2017-08-06.
 */

public class CharacterCardAdapter extends ArrayAdapter<CharacterCard> {

    private final Context context;
    private final List<CharacterCard> objects;
    private final int layoutResourceId;

    public CharacterCardAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CharacterCard> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResourceId = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.container = (LinearLayout) row.findViewById(R.id.container);
            holder.textView = (TextView) row.findViewById(R.id.verifyResult);
            row.setTag(holder);
        } else {
            holder = (ViewHolder)row.getTag();
        }

        // init
        if (holder.container.getChildCount() > 0) {
            holder.container.removeViewAt(0);
        }
        holder.textView.setVisibility(View.GONE);
        FontUtils.setTypeface(context, context.getAssets(), holder.textView);

        CharacterCard characterCard = objects.get(position);

        // add path view
        final PathView pathView = new PathView(context);
        pathView.setPathColor(Color.parseColor("#FFFFFF"));
        pathView.setPathWidth(CommonUtils.dpToPixel(context, 1));
        holder.container.addView(pathView);
//        pathView.useNaturalColors();
        pathView.setFillAfter(true);
//        pathView.setLayoutParams(new LinearLayout.LayoutParams(CommonUtils.dpToPixel(context, 35), CommonUtils.dpToPixel(context, 40)));
//        pathView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        pathView.setSvgResource(characterCard.getCardResourceId());
//        holder.textView.setText(characterCard.getInfo());

//        pathView.setPercentage(1);

        pathView.getPathAnimator()
                .duration(200)
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();

        return row;
    }

    private static class ViewHolder {
        LinearLayout container;
        TextView textView;
    }

}
