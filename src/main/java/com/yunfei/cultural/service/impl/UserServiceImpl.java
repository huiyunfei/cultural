package com.yunfei.cultural.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.constant.CommonConstants;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.mapper.TUserMapper;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.model.vo.LoginResult;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.MD5Utils;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
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
    public ResultObj login(LoginParams params) {
        ResultObj resultObj = new ResultObj();
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
            LoginResult result=new LoginResult();
            BeanUtils.copyProperties(user,result);
            return ResultUtil.createSuccessResult(resultObj,"",result);
        }
        return ResultUtil.createLocgicExceptionResult(resultObj,"用户名密码错误",null);
    }

    @Override
    public void logout(JSONObject params) {
        TUser user = userMapper.selectByPrimaryKey(params.getInteger("id"));
        if(user==null){
            throw new LogicException("用户不存在");
        }
        // 清除旧的TOKEN
        if (StringUtils.isEmpty(user.getToken())) {
            throw new LogicException("用户未登录");
        }
        redisTemplate.delete(CommonConstants.CULTURAL_USER_ACCOUNT+":"+ user.getToken());
        user.setToken(null);
        user.setUpdateTime(new Date());
        // 更新信息
        userMapper.updateByPrimaryKey(user);

    }

    /**
     * 刷新TOKEN
     */
    private String refreshToken(String token) {
        // 清除旧的TOKEN
        if (!StringUtils.isEmpty(token)) {
            redisTemplate.delete(CommonConstants.CULTURAL_USER_ACCOUNT +":"+token);
        }
        // 生成新的TOKEN
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**
     * 保存TOKEN
     */
    private void saveToken(String token, String userId) {
        redisTemplate.opsForValue().set(CommonConstants.CULTURAL_USER_ACCOUNT +":"+ token, userId, 604800, TimeUnit.SECONDS);
    }
}
