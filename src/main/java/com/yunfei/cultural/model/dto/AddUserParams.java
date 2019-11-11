package com.yunfei.cultural.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
@Builder
public class AddUserParams {

    private Integer id;

    private String username;

    private String telephone;

    private String phone;

    private String email;

    private String name;

    private Integer roleId;

    private String password;

    private String comfirmPassword;

    private Integer status;

}
