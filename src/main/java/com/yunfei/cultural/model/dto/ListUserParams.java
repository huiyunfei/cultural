package com.yunfei.cultural.model.dto;

import lombok.Data;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
public class ListUserParams {

    private String username;

    private String telephone;

    private String phone;

    private String email;

    private String name;

    private Integer status;

    private Integer roleId;

}
