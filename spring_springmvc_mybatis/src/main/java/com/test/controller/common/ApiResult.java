package com.test.controller.common;

public class ApiResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiResult() {
    }

    public ApiResult(int code, String msg, T data) {
//        this();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiResult<Object> success() {
        return new ApiResult<Object>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
    }

    public ApiResult(T data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data;
    }

}
