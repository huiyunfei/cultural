package com.yunfei.cultural.service.impl;

import com.yunfei.cultural.entity.User;
import com.yunfei.cultural.mapper.UserDao;
import com.yunfei.cultural.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

}
