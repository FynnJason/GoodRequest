package com.fynnjason.app.goodrequest.network;

import android.content.Context;

import com.lzy.okgo.model.HttpHeaders;

/**
 * Created by FynnJason.
 * Function：所有的网络请求
 */
public class NetRequest {
    public static void HotKeyData(Context context, OkGoCallback callback) {
        OkGoHelper.request(context, API.HotKey, callback);
    }

    public static void UserInfoData(Context context, String token, OkGoCallback callback) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("token", token);
        OkGoHelper.request(context, API.UserInfo, headers, callback);
    }
}
