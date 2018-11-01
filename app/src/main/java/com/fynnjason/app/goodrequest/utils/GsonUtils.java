package com.fynnjason.app.goodrequest.utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

/**
 * Created by FynnJason.
 * Function：解析工具类
 */
public class GsonUtils {
    private static Gson create() {
        return GsonHolder.sGson;
    }

    private static class GsonHolder {
        private static Gson sGson = new Gson();
    }

    public static <T> T fromJson(String json, Class<T> tClass) throws JsonIOException {
        return create().fromJson(json, tClass);
    }
}
