package com.yunfei.cultural.model.vo;

import lombok.Data;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
public class LoginResult {

    private Integer id;

    private String email;

    private String name;

    private String token;

    private String headUrl;

    private String phone;

    private Boolean sex;
}
