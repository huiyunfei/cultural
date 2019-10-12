package com.yunfei.cultural.service.impl;

import com.yunfei.cultural.constant.CommonConstants;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.mapper.TUserMapper;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.model.vo.LoginResult;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.MD5Utils;
import com.yunfei.cultural.utils.exception.LogicException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public LoginResult login(LoginParams params) {
        TUser user = userMapper.findByUserName(params.getUsername());
        if(user==null){
            throw new LogicException("用户不存在");
        }
        if(user.getPassword().equals(MD5Utils.getMD5(params.getPassword()))){
            String token = this.refreshToken(user.getToken());
            user.setToken(token);
            user.setUpdateTime(new Date());
            this.userMapper.updateByPrimaryKey(user);
            this.saveToken(token, String.valueOf(user.getId()));
        }
        LoginResult result=new LoginResult();
        BeanUtils.copyProperties(user,result);
        return result;
    }

    /**
     * 刷新TOKEN
     */
    private String refreshToken(String oldToken) {
        // 清除旧的TOKEN
        if (!StringUtils.isEmpty(oldToken)) {
            redisTemplate.delete(CommonConstants.CULTURAL_USER_ACCOUNT + oldToken);
        }
        // 生成新的TOKEN
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**
     * 保存TOKEN
     */
    private void saveToken(String token, String userId) {
        redisTemplate.opsForValue().set(CommonConstants.CULTURAL_USER_ACCOUNT + token, userId, 604800, TimeUnit.SECONDS);
    }
}
