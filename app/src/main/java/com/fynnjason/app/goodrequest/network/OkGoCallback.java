package com.fynnjason.app.goodrequest.network;

/**
 * Created by FynnJason.
 * Function：
 */
public interface OkGoCallback {
    void success(String json);

    void error(int code, String msg);
}
