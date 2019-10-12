package com.yunfei.cultural.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TUser {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String name;

    private Date createTime;

    private Date updateTime;

    private String token;

    private String headUrl;

    private String phone;

    private Boolean sex;

}