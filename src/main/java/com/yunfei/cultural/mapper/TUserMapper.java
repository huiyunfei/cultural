package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TUser;

public interface TUserMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(TUser record);


    int insertSelective(TUser record);


    TUser selectByPrimaryKey(Integer id);

    TUser findByUserName(String username);

    int updateByPrimaryKeySelective(TUser record);


    int updateByPrimaryKey(TUser record);
}