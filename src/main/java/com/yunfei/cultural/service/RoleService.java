package com.yunfei.cultural.service;

import com.yunfei.cultural.entity.TPermissions;
import com.yunfei.cultural.model.dto.AddRoleParams;
import com.yunfei.cultural.model.vo.DetailRoleResult;
import com.yunfei.cultural.model.vo.ListRoleResult;

import java.util.List;

/**
 * Created by huiyunfei on 2019/4/12.
 */
public interface RoleService {


    List<ListRoleResult> listRole();

    List<TPermissions> listPermissions();

    void delRole(Integer id);

    DetailRoleResult findRoleById(Integer id);

    void saveRole(AddRoleParams params);
}
