package com.yunfei.cultural.utils.result;

import java.io.Serializable;

/**
 * Created by huiyunfei on 2019/10/11.
 */
public class ResultObj implements Serializable {

    private static final long serialVersionUID = -377802885680820417L;
    public static final int SUCCESS = 100;
    public static final int ERROR = 999;
    private java.lang.Integer info;
    private java.lang.String msg;
    private java.lang.Object obj;

    public ResultObj() { /* compiled code */ }

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public static int getERROR() {
        return ERROR;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ResultObj{" +
                "info=" + info +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
