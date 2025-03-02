package com.test.controller.common;

public enum ResultEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    private final Integer code;
    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
