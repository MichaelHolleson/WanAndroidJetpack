package com.michaelholleson.network;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private OkHttpClient mOkHttpClient;

    private Retrofit mRetrofit;

    private NetworkManager() {
    }

    public static NetworkManager getInstance() {
        return Holder.instance;
    }

    static class Holder {
        static NetworkManager instance = new NetworkManager();
    }

    public void init(String host) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        mOkHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

}
