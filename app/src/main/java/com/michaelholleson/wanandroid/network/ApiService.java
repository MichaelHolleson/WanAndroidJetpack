package com.michaelholleson.wanandroid.network;

import com.michaelholleson.wanandroid.bean.Banner;
import com.michaelholleson.wanandroid.network.reponse.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String HOST = "https://www.wanandroid.com";

    @GET("/banner/json")
    Observable<Response<List<Banner>>> getBanner();







}
