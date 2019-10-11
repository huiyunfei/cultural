package com.yunfei.cultural.utils;

import java.io.Serializable;

/**
 * Created by huiyunfei on 2019/10/11.
 */
public class ResultObj<T> implements Serializable {


    private static final long serialVersionUID = -999362211833007653L;

    private boolean success;

    private String message;

    private T data;

    private String errorcode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public ResultObj() {

    }
}
