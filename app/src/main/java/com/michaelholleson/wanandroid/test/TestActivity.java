package com.michaelholleson.wanandroid.test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.michaelholleson.wanandroid.bean.Banner;
import com.michaelholleson.wanandroid.network.NetworkManager;
import com.michaelholleson.wanandroid.network.composer.ResponseComposer;
import com.michaelholleson.wanandroid.network.composer.ThreadComposer;
import com.michaelholleson.wanandroid.R;
import com.michaelholleson.wanandroid.base.BaseActivity;
import com.michaelholleson.wanandroid.network.ApiService;
import com.michaelholleson.wanandroid.utils.LogUtils;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class TestActivity extends BaseActivity implements View.OnClickListener {


    AppCompatButton mBtnNetwork;

    AppCompatButton mBtnRxjava;

    AppCompatTextView mTvResult;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtnNetwork = findViewById(R.id.btn_network);
        mBtnRxjava = findViewById(R.id.btn_rxjava);
        mTvResult = findViewById(R.id.tv_result);

        mBtnNetwork.setOnClickListener(this);
        mBtnRxjava.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_network) {

            ApiService apiService = NetworkManager.getInstance().create(ApiService.class);
            Disposable disposable = apiService.getBanner()
                    .compose(ThreadComposer.handleThread())
                    .compose(ResponseComposer.handleResponse())
                    .subscribe(banners -> {

                        LogUtils.d(banners.toString());
                        mTvResult.setText(banners.toString());

                    }, throwable -> {

                    });


        } else if (view.getId() == R.id.btn_rxjava) {


        }
    }
}
