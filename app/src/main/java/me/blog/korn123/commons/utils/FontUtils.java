package me.blog.korn123.commons.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hanjoong on 2017-08-06.
 */

public class FontUtils {

    private volatile static Typeface mTypeface;

    public static void setTypeface(Context context, AssetManager assetManager, TextView view) {
        view.setTypeface(getTypeface(context, assetManager));
    }

    public static Typeface getTypeface(Context context, AssetManager assetManager) {
        if (mTypeface == null) {
            mTypeface = setCurrentTypeface(context, assetManager);
        }
        return  mTypeface;
    }

    public static Typeface setCurrentTypeface(Context context, AssetManager assetManager) {
        String currentFont = CommonUtils.loadStringPreference(context, "font_setting", "NanumPen.ttf");
        if (StringUtils.equals(currentFont, "Default")) {
            mTypeface = Typeface.DEFAULT;
        } else {
            mTypeface = Typeface.createFromAsset(assetManager, "fonts/" + currentFont);
        }
        return mTypeface;
    }

}
