package com.michaelholleson.wanandroid.test;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.michaelholleson.network.NetworkManager;
import com.michaelholleson.network.reponse.ResponseTransformer;
import com.michaelholleson.network.schedulers.SchedulerProvider;
import com.michaelholleson.wanandroid.R;
import com.michaelholleson.wanandroid.base.BaseActivity;
import com.michaelholleson.wanandroid.bean.Banner;
import com.michaelholleson.wanandroid.network.ApiService;

import java.util.List;

import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

public class TestActivity extends BaseActivity {


    AppCompatButton mBtnNetwork;

    AppCompatTextView mTvResult;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtnNetwork = findViewById(R.id.btn_network);
        mTvResult = findViewById(R.id.tv_result);

        mBtnNetwork.setOnClickListener((view) -> {
            ApiService apiService = NetworkManager.getInstance().getRetrofit().create(ApiService.class);

            apiService.getBanner()
                    .compose(ResponseTransformer.handleResult())
                    .compose(SchedulerProvider.getInstance().applySchedulers())
                    .subscribe(new Consumer<List<Banner>>() {
                        @Override
                        public void accept(List<Banner> banners) throws Exception {

                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });


        });


    }


}
