package com.michaelholleson.wanandroid;

import com.michaelholleson.wanandroid.network.NetworkManager;
import com.michaelholleson.wanandroid.base.BaseApp;
import com.michaelholleson.wanandroid.network.ApiService;

public class WanApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.getInstance().init(ApiService.HOST);
    }
}
