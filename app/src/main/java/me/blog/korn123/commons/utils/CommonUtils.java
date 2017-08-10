package me.blog.korn123.commons.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.TypedValue;

import java.text.DecimalFormat;

/**
 * Created by hanjoong on 2017-08-06.
 */

public class CommonUtils {

    public static String loadStringPreference(Context context, String key, String defaultValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, defaultValue);
    }

    public static int dpToPixel(Context context, int dp) {
        return dpToPixel(context, dp, 0);
    }

    public static int dpToPixel(Context context, int dp, int policy) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        int pixel = 0;
        switch (policy) {
            case 0:
                pixel = (int) px;
                break;
            case 1:
                pixel = Math.round(px);
                break;
        }
        return pixel;
    }

    public static int getResourceId(Resources resources, String packageName, String variableName, String resourceName) {
        try {
            return resources.getIdentifier(variableName, resourceName, packageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getSecondsWithDecimalFormat(long timeMillis) {
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        return decimalFormat.format(timeMillis / 1000f);
    }

    public static String getMillisWithDecimalFormat(long timeMillis) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        float temp = Float.valueOf(decimalFormat.format(timeMillis / 1000f));
        return decimalFormat.format(temp % 1);
    }

    public static void threadSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
