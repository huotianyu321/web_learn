package com.ssmtest.controller.common;

public class AppException extends RuntimeException {
    public Integer getCode() {
        return code;
    }

    private final Integer code;

    public AppException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
