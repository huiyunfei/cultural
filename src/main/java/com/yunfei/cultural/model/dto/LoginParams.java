package com.yunfei.cultural.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Setter
@Getter
public class LoginParams {

    private String username;

    private String password;
    //0登录前台，1登录后台
    private Integer loginType=0;

}
