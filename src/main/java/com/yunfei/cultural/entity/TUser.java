package com.yunfei.cultural.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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