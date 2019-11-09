package com.yunfei.cultural.model.vo;

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
public class UserRoleModel {

    private Integer userId;

    private String username;

    private Integer roleId;

    private String roleName;

    private String roleMarking;

}
