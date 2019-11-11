package com.yunfei.cultural.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TUser implements Serializable {
    private static final long serialVersionUID = 1L;
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

    private Integer sex;
    //0正常1停用
    private Integer status;

    private String telephone;

    //盐
    private String salt;

}