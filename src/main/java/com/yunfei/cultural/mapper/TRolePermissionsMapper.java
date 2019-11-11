package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TRolePermissions;
import com.yunfei.cultural.model.vo.RolePermissionsModel;

import java.util.List;

public interface TRolePermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRolePermissions record);

    int insertSelective(TRolePermissions record);

    TRolePermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRolePermissions record);

    int updateByPrimaryKey(TRolePermissions record);

    List<RolePermissionsModel> findRolePermissionsByUserId(Integer userId);

    List<RolePermissionsModel> findRolePermissions();

    List<TRolePermissions> selectByRoleId(Integer id);

    void deleteByRoleId(Integer id);
}