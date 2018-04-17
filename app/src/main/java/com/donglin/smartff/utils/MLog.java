package com.donglin.smartff.utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/12/19 0019.
 */

public class MLog {

    public static final String TAG = "DLSmartFF";
    public static boolean isShow = true;

    public MLog() {

    }

    public static void e(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }

    public static void v(Object object) {
        if (isShow)
            Log.e(TAG, object + "");

    }

    public static void d(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }

    public static void i(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }

    public static void w(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }


}
