package com.yunfei.cultural.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TRole {
    private Integer id;

    private String roleName;

    private String remark;
    /**
     * 角色对应权限集合
     */
    private Set<TRolePermissions> permissions;

   
}