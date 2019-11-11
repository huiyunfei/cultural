package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.model.dto.ListUserParams;
import com.yunfei.cultural.model.vo.DetailUserResult;
import com.yunfei.cultural.model.vo.ListUserResult;

import java.util.List;

public interface TUserMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(TUser record);


    int insertSelective(TUser record);


    TUser selectByPrimaryKey(Integer id);

    TUser findByUserName(String username);

    int updateByPrimaryKeySelective(TUser record);


    int updateByPrimaryKey(TUser record);

    List<ListUserResult.UserResult> findByParams(ListUserParams params);

    DetailUserResult findUserById(Integer id);
}