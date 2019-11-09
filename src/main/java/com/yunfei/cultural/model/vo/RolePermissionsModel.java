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
public class RolePermissionsModel {

    private Integer userId;

    private Integer roleId;

    private Integer rolePermissionsId;

    private String permissionsName;

    private String permissionsMarking;

}
