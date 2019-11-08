package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TPermissions;

public interface TPermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TPermissions record);

    int insertSelective(TPermissions record);

    TPermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPermissions record);

    int updateByPrimaryKey(TPermissions record);
}