package com.yunfei.cultural.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.mapper.TUserMapper;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.model.vo.LoginResult;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.exception.LogicException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public LoginResult login(LoginParams params) {
        LoginResult result = new LoginResult();
        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();
        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(params.getUsername(), params.getPassword());
        // 4、认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(token);
            // 构建缓存用户信息返回给前端
            TUser user = (TUser) currentUser.getPrincipals().getPrimaryPrincipal();
            if(user.getStatus()==1){
                throw new LogicException("账号已禁用");
            }
            BeanUtils.copyProperties(user, result);
            result.setToken(currentUser.getSession().getId().toString());
        }catch (UnknownAccountException e) {
            throw new LogicException("账号不存在!");
        }catch (IncorrectCredentialsException e) {
            throw new LogicException("密码错误!");
        }
        return result;
    }

    @Override
    public void logout(JSONObject params) {

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @Override
    public TUser findUserByUserName(String username) {
        return userMapper.findByUserName(username);
    }

}
