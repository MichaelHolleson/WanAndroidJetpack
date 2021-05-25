package com.michaelholleson.wanandroid.network.composer;

import com.michaelholleson.wanandroid.network.exception.ApiException;
import com.michaelholleson.wanandroid.network.exception.ExceptionHandler;
import com.michaelholleson.wanandroid.network.reponse.Response;
import com.michaelholleson.wanandroid.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

public class ResponseComposer {

    private static class ResponseFunction<T> implements Function<Response<T>, ObservableSource<T>> {

        @Override
        public ObservableSource<T> apply(Response<T> tResponse) throws Exception {
            int code = tResponse.errorCode;
            String message = tResponse.errorMsg;
            if (code == 0) {
                return Observable.just(tResponse.data);
            } else {
                return Observable.error(new ApiException(code, message));
            }
        }
    }

    private static class ErrorResumeFunction<T> implements Function<Throwable, ObservableSource<? extends Response<T>>> {

        @Override
        public ObservableSource<? extends Response<T>> apply(Throwable throwable) throws Exception {
            return Observable.error(ExceptionHandler.handleException(throwable));
        }
    }

    public static <T> ObservableTransformer<Response<T>, T> handleResponse() {
        return new ObservableTransformer<Response<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<Response<T>> upstream) {
                return upstream.onErrorResumeNext(new ErrorResumeFunction<>())
                        .flatMap(new ResponseFunction<>());
            }
        };
    }

}
