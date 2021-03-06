package com.fynnjason.app.goodrequest.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by FynnJason.
 * Function：网络工具类
 */
public class NetworkUtils {
    /**
     * 检查网络是否可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getApplicationContext().getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            return false;
        }
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isAvailable();
    }

}
