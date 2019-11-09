package com.yunfei.cultural.utils.result;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

/**
 * Created by hui.yunfei@qq.com on 2019/11/9
 */
public class ByteSourceUtils {

    public static ByteSource bytes(byte[] bytes){
        return new SimpleByteSource(bytes);
    }
    public static ByteSource bytes(String arg0){
        return new SimpleByteSource(arg0.getBytes());
    }
}
