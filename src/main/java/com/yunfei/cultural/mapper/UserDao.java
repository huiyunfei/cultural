package com.yunfei.cultural.mapper;

import com.yunfei.cultural.entity.User;

/**
 * Created by huiyunfei on 2019/4/12.
 */

public interface UserDao {
    User findById(int id);

}
