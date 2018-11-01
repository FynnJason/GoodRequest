package com.fynnjason.app.goodrequest.utils;

import android.util.Log;

import com.fynnjason.app.goodrequest.BuildConfig;

/**
 * Created by FynnJason on 2018/6/19.
 * Function：日志工具
 */
public class LogUtils {

    public static void e(String msg) {
        if (BuildConfig.DEBUG)
            Log.e("MY_LOG", msg);
    }
}
