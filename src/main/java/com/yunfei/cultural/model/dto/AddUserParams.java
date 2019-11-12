package com.yunfei.cultural.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
