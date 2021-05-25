package com.michaelholleson.wanandroid.network.exception;

public class ApiException extends Exception {
    private int code;

    private String exMessage;

    public ApiException(int code, String exMessage) {
        this.code = code;
        this.exMessage = exMessage;
    }

    public ApiException(int code, String message, String exMessage) {
        super(message);
        this.code = code;
        this.exMessage = exMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getExMessage() {
        return exMessage;
    }

    public void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }
}
