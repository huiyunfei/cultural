package com.yunfei.cultural.utils.exception;

/**
 * @author http://gblfy.com
 * @Description 登录异常
 * @Date 2019/9/14 15:34
 * @version1.0
 */
public class UnLoginException extends RuntimeException {
    public UnLoginException(String message) {
        super(message);
    }
}
