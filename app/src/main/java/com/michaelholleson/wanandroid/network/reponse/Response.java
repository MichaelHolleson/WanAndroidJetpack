package com.michaelholleson.wanandroid.network.reponse;

public class Response<T> {

    public String errorMsg;

    public int errorCode;

    public T data;

    @Override
    public String toString() {
        return "BaseResp{" +
                "errorMsg='" + errorMsg + '\'' +
                ", errorCode=" + errorCode +
                ", data=" + data +
                '}';
    }
}
