package com.yunfei.cultural.service;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.model.dto.AddUserParams;
import com.yunfei.cultural.model.dto.ListUserParams;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.model.vo.DetailUserResult;
import com.yunfei.cultural.model.vo.ListUserResult;
import com.yunfei.cultural.model.vo.LoginResult;

/**
 * Created by huiyunfei on 2019/4/12.
 */
public interface UserService {

    LoginResult login(LoginParams params);

    void logout(JSONObject params);

    TUser findUserByUserName(String username);

    void updatePassword(Integer userId, String oldPassword, String newPassword);

    ListUserResult listUser(ListUserParams params);

    DetailUserResult findUserById(Integer id);

    void saveUser(AddUserParams params);

    void delUser(Integer id);
}
