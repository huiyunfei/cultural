package com.yunfei.cultural.web;

import com.yunfei.cultural.Application;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.mapper.TUserMapper;
import com.yunfei.cultural.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private UserService userService;
    @Test
    public void findById() {
        TUser tUser = userMapper.selectByPrimaryKey(1);
        System.out.println(tUser);

    }


}