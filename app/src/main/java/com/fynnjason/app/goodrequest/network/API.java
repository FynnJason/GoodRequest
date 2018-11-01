package com.fynnjason.app.goodrequest.network;

/**
 * Created by FynnJason.
 * Function：API
 */
class API {
    static final int JSON_ERROR = -98;
    static final int NETWORK_ERROR = -99;
    static final int RESPONSE_ENPTY = -100;
    static final int SUCCESS = 200;

    //服务器地址
    private static final String BASE_URL = "http://api.zhepm.com/api/";
    //热词搜索
    static final String HotKey = BASE_URL + "goods/hotkey";
    //用户信息
    static final String UserInfo = BASE_URL + "user/userinfo";
}
