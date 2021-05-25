package com.michaelholleson.wanandroid.utils;

import android.util.Log;

public class LogUtils {

    private static final String TAG = "LogUtils";

    public static void d(String s) {
        Log.d(TAG, "--->> " + s);
    }

    public static void e(String s) {
        Log.e(TAG, "--->> " + s);
    }
}
