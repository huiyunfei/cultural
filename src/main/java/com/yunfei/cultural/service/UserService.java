package com.yunfei.cultural.service;

import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.model.dto.LoginParams;

/**
 * Created by huiyunfei on 2019/4/12.
 */
public interface UserService {

    TUser login(LoginParams params);
}
