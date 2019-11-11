package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TPermissions;

import java.util.List;

public interface TPermissionsMapper {

    List<TPermissions> selectAllByType(int i);
}