package com.yunfei.cultural.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Data
public class User {

    private int id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String headUrl;

    private int sex;

    private String name;

    private String token;

    private Date updateTime;

    private Date createTime;
}
