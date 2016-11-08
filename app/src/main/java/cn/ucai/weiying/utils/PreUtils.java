package cn.ucai.weiying.utils;

import android.content.Context;
import android.content.SharedPreferences;

import cn.ucai.weiying.widget.theme.Theme;

/**
 * Created by Administrator on 2016/11/8.
 */
public class PreUtils {

    private static SharedPreferences getSharedPreferences(final Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getString(final Context context, final String key, final String defaultValue) {
        return PreUtils.getSharedPreferences(context).getString(key, defaultValue);
    }

    public static boolean putString(final Context context, final String key, final String pValue) {
        SharedPreferences.Editor edit = PreUtils.getSharedPreferences(context).edit();
        edit.putString(key, pValue);
        return edit.commit();
    }

    public static Theme getCurrentTheme(Context context) {
        return Theme.valueOf(PreUtils.getString(context, "app_theme", Theme.Red.name()));
    }

    public static void setCurrentTheme(Context context, Theme currentTheme) {
        PreUtils.putString(context, "app_theme", currentTheme.name());
    }

}
