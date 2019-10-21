package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Slf4j
@RestController
@RequestMapping("/system")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultObj distLogin(@RequestBody LoginParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(StringUtils.isEmpty(params.getUsername()) || StringUtils.isEmpty(params.getPassword())){
                throw new LogicException("账号密码不能为空");
            }
            return userService.login(params);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("login error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("login system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultObj logout(@RequestBody JSONObject params) {
        ResultObj result = new ResultObj();
        try {
            Integer id = params.getInteger("id");
            if (id == null){
                throw new LogicException("参数异常");
            }
            userService.logout(params);
            ResultUtil.createSuccessResult(result, "退出成功", null);
        } catch (LogicException le) {
            log.warn("logout error:{}", le);
            ResultUtil.createLocgicExceptionResult(result, le.getMessage());
        } catch (Exception e) {
            log.error("logout system error:{}", e);
            ResultUtil.createSystemExceptionResult(result, e.getMessage());
        }
        return result;
    }
}

















