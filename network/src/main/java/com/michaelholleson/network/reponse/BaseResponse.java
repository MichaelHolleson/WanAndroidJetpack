package com.michaelholleson.network.reponse;

public class BaseResponse<T> {

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
