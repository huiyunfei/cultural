package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.shiro.ShiroRealm;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
    public ResultObj listUser(@RequestBody JSONObject params){
        ResultObj resultObj = new ResultObj();

//        try {
//            if(params.getQueryType()==null || StringUtils.isBlank(params.getKeyword())){
//                throw new LogicException("必填参数为空");
//            }
//            List<CulturalFamousHtResult> list = queryService.listCulturalFamousHt(params);
//            ResultUtil.createSuccessResult(resultObj,"",list);
//        } catch (LogicException e) {
//            e.printStackTrace();
//            log.warn("listCulturalFamousHt error:{}",e.getMessage());
//            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
//        }catch (Exception e) {
//            e.printStackTrace();
//            log.error("listCulturalFamousHt system error:{}",e.getMessage());
//            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
//        }
        return resultObj;
    }

    @RequestMapping(value = "/detailUser", method = RequestMethod.POST)
    public ResultObj detailUser(@RequestBody JSONObject params) {

        Subject subject = SecurityUtils.getSubject();
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        shiroRealm.clearCachedAuthorizationInfo(subject.getPrincipals());
        //认证
//        PrincipalCollection principals = subject.getPrincipals();
//        if(principals instanceof TUser){
//            shiroRealm.clearCachedAuthenticationInfo(((TUser) principals).getId());
//        }
        shiroRealm.clearCachedAuthenticationInfo(subject.getPrincipals());


        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj,"用户详情");



    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResultObj addUser(@RequestBody JSONObject params) {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj, "添加用户");
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public ResultObj delUser(@RequestBody JSONObject params) {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj, "删除用户");
    }


}
