package com.example.gift_speak_demo.tool;

import android.util.Log;

/**
 * Created by yangjw on 2016/10/31.
 */
public class LogUtils {

    public static final boolean DEBUG = true;
    private static final String TAG = "mvc_demo";

    public static void log(Class clazz,String msg) {
        if (DEBUG) {
            Log.d(TAG, clazz.getName() + " --> " + msg);
        }
    }
}
