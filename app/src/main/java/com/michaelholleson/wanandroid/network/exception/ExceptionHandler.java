package com.michaelholleson.wanandroid.network.exception;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

public class ExceptionHandler {

    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;

    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;

    /**
     * 网络错误
     */
    public static final int NETWORK_ERROR = 1002;

    /**
     * 协议错误
     */
    public static final int HTTP_ERROR = 1003;

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            ex = new ApiException(PARSE_ERROR, e.getMessage());
        } else if (e instanceof ConnectException) {
            ex = new ApiException(NETWORK_ERROR, e.getMessage());
        } else if (e instanceof UnknownHostException || e instanceof SocketTimeoutException) {
            ex = new ApiException(NETWORK_ERROR, e.getMessage());
        } else {
            ex = new ApiException(UNKNOWN, e.getMessage());
        }
        return ex;
    }
}
