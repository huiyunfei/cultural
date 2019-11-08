package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TRolePermissions;

public interface TRolePermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRolePermissions record);

    int insertSelective(TRolePermissions record);

    TRolePermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRolePermissions record);

    int updateByPrimaryKey(TRolePermissions record);
}