package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.model.dto.AddUserParams;
import com.yunfei.cultural.model.dto.ListUserParams;
import com.yunfei.cultural.model.vo.DetailUserResult;
import com.yunfei.cultural.model.vo.ListUserResult;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 后台用户管理类，拥有admin权限的可以访问
 * @Author: HuiYunfei
 * @Date: 2019/11/9
 */
@RestController
@Slf4j
@RequestMapping("/user")
@RequiresRoles("admin")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/listUser", method = RequestMethod.POST)
    public ResultObj listUser(@RequestBody ListUserParams params){
        ResultObj resultObj = new ResultObj();
        try {
            ListUserResult result = userService.listUser(params);
            ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            log.warn("listUser error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listUser system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    @RequestMapping(value = "/detailUser", method = RequestMethod.POST)
    public ResultObj detailUser(@RequestBody JSONObject params) {

        ResultObj resultObj = new ResultObj();
        try {
            if(params.getInteger("id")==null){
                throw new LogicException("用户id为空");
            }
            DetailUserResult result=userService.findUserById(params.getInteger("id"));
            return ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            log.warn("detailUser error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("detailUser system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResultObj saveUser(@RequestBody AddUserParams params) {

        ResultObj resultObj = new ResultObj();
        try {
            userService.saveUser(params);
            return ResultUtil.createSuccessResult(resultObj, "");
        } catch (LogicException e) {
            log.warn("saveUser error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("saveUser system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public ResultObj delUser(@RequestBody JSONObject params) {
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getInteger("id")==null){
                throw new LogicException("用户id为空");
            }
            userService.delUser(params.getInteger("id"));
            return ResultUtil.createSuccessResult(resultObj, "");
        } catch (LogicException e) {
            log.warn("delUser error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("delUser system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }



}
