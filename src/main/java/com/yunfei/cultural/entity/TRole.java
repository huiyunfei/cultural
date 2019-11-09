package com.yunfei.cultural.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TRole {
    private Integer id;

    private String roleName;

    private String remark;

    //角色标示
    private String roleMarking;

}