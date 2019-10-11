package com.yunfei.cultural.web;

import com.yunfei.cultural.entity.User;
import com.yunfei.cultural.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Slf4j
@RestController
@RequestMapping("/testUser")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id") Integer id) {
        log.info("findById in：{} ", id);
        return userService.findById(id);
    }

}

















