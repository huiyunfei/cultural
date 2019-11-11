package com.yunfei.cultural.model.vo;

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
@NoArgsConstructor
@AllArgsConstructor
public class DetailRoleResult {

    private Integer id;

    private String roleName;

    private String remark;

    private List<Integer> permissionsId;

}
