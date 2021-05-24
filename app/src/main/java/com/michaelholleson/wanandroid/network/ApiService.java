package com.michaelholleson.wanandroid.network;

import com.michaelholleson.wanandroid.bean.Banner;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String HOST = "https://www.wanandroid.com";

    @GET("/banner/json")
    Observable<List<Banner>> getBanner();







}
