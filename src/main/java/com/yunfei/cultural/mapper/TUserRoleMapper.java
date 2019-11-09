package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TUserRole;
import com.yunfei.cultural.model.vo.UserRoleModel;

import java.util.List;

public interface TUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    TUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);

    List<UserRoleModel> findUserRoleByUserId(Integer userId);
}