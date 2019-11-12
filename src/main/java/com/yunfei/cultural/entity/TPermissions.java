package com.yunfei.cultural.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TPermissions {
    private Integer id;

    private String permissionsName;

    //权限标示
    private String premissionsMarking;

    //0表单权限1功能权限
    private Integer type;


}