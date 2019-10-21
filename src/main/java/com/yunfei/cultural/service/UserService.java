package com.yunfei.cultural.service;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.model.vo.LoginResult;

/**
 * Created by huiyunfei on 2019/4/12.
 */
public interface UserService {

    LoginResult login(LoginParams params);

    void logout(JSONObject params);
}
