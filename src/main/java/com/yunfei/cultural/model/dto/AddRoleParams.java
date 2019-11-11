package com.yunfei.cultural.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddRoleParams {

    private Integer id;

    private String roleName;

    private String remark;

    private String roleMarking;

    private List<Integer> permissionsId;

}
