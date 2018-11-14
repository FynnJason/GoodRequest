package com.fynnjason.app.goodrequest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fynnjason.app.goodrequest.model.HotKeyModel;
import com.fynnjason.app.goodrequest.model.UserInfoModel;
import com.fynnjason.app.goodrequest.network.NetRequest;
import com.fynnjason.app.goodrequest.network.OkGoCallback;
import com.fynnjason.app.goodrequest.utils.GsonUtils;
import com.fynnjason.app.goodrequest.utils.LogUtils;
import com.fynnjason.app.goodrequest.weights.ExperienceProgress;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;

        //请求热词接口数据
        NetRequest.HotKeyData(context, new OkGoCallback() {
            @Override
            public void success(String json) {
                HotKeyModel model = GsonUtils.fromJson(json, HotKeyModel.class);
                LogUtils.e(Arrays.toString(model.getData().toArray()));
            }

            @Override
            public void error(int code, String msg) {
                LogUtils.e("失败code: " + code + ",msg：" + msg);
            }
        });

        //请求用户信息接口数据
        NetRequest.UserInfoData(context, "6B31C097F724C951AB5F8321AA1B13B3", new OkGoCallback() {
            @Override
            public void success(String json) {
                UserInfoModel model = GsonUtils.fromJson(json, UserInfoModel.class);
                LogUtils.e(model.getData().getNickname());
            }

            @Override
            public void error(int code, String msg) {
                LogUtils.e("失败code：" + code + ",msg：" + msg);
            }
        });

        ExperienceProgress vipPro = findViewById(R.id.vip_progress);
        vipPro.setMax(2000);
        vipPro.setProgress(1352);
    }

}
