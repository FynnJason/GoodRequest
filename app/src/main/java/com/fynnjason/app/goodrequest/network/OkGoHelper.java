package com.fynnjason.app.goodrequest.network;

import android.content.Context;
import android.text.TextUtils;

import com.fynnjason.app.goodrequest.model.BaseModel;
import com.fynnjason.app.goodrequest.utils.GsonUtils;
import com.fynnjason.app.goodrequest.utils.LogUtils;
import com.fynnjason.app.goodrequest.utils.NetworkUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

/**
 * Created by FynnJason.
 * Function：网络层封装
 */
public final class OkGoHelper {

    /**
     * 统一回调
     * 以BaseModel基类，仅解析code和msg来处理
     * 当请求成功时，返回整个Json字符串，更加灵活
     *
     * @param callBack
     */
    private static StringCallback stringCallBack(final OkGoCallback callBack) {
        return new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtils.e(response.body());
                if (!TextUtils.isEmpty(response.body())) {
                    try {
                        BaseModel model = GsonUtils.fromJson(response.body(), BaseModel.class);
                        if (model.getCode() == API.SUCCESS) {
                            callBack.success(response.body());
                        } else {
                            callBack.error(model.getCode(), model.getMsg());
                        }
                    } catch (Exception e) {
                        callBack.error(API.JSON_ERROR, e.getMessage());
                    }
                } else {
                    callBack.error(API.RESPONSE_ENPTY, "无法请求数据");
                }
            }

            @Override
            public void onError(Response<String> response) {
                callBack.error(response.code(), "服务器连接失败");
            }
        };
    }

    /**
     * 网络请求封装
     *
     * @param context  上下文
     * @param api      api地址
     * @param headers  headers
     * @param params   参数
     * @param callBack 回调
     */
    public static void request(Context context, String api, HttpHeaders headers, HttpParams params, OkGoCallback callBack) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            OkGo.<String>post(api)
                    .headers(headers)
                    .params(params)
                    .execute(stringCallBack(callBack));
        } else {
            callBack.error(API.NETWORK_ERROR, "没有网络了");
        }
    }

    /**
     * 网络请求封装
     *
     * @param context  上下文
     * @param api      api地址
     * @param params   headers
     * @param callBack 回调
     */
    public static void request(Context context, String api, HttpParams params, OkGoCallback callBack) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            OkGo.<String>post(api)
                    .params(params)
                    .execute(stringCallBack(callBack));
        } else {
            callBack.error(API.NETWORK_ERROR, "没有网络了");
        }
    }

    /**
     * 网络请求封装
     *
     * @param context  上下文
     * @param api      api地址
     * @param headers  headers
     * @param callBack 回调
     */
    public static void request(Context context, String api, HttpHeaders headers, OkGoCallback callBack) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            OkGo.<String>post(api)
                    .headers(headers)
                    .execute(stringCallBack(callBack));
        } else {
            callBack.error(API.NETWORK_ERROR, "没有网络了");
        }
    }

    /**
     * 网络请求封装
     *
     * @param context  上下文
     * @param api      api地址
     * @param callBack 回调
     */
    public static void request(Context context, String api, OkGoCallback callBack) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            OkGo.<String>post(api)
                    .execute(stringCallBack(callBack));
        } else {
            callBack.error(API.NETWORK_ERROR, "没有网络了");
        }
    }
}
