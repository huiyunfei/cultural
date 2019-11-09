package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.exception.UnLoginException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author http://gblfy.com
 * @Description 登录
 * @Date 2019/9/14 15:34
 * @version1.0
 */
@Slf4j
@RestController
@RequestMapping("/system")
public class LoginController {

    @Autowired
    private UserService userService;



    /**
     * @Description: 登录，使用shiro验证和赋权
     * @Author: HuiYunfei
     * @Date: 2019/11/9
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultObj distLogin(@RequestBody LoginParams params){
        ResultObj resultObj = new ResultObj();

        if(org.springframework.util.StringUtils.isEmpty(params.getUsername()) || StringUtils.isEmpty(params.getPassword())){
            throw new LogicException("账号密码不能为空");
        }
        return ResultUtil.createSuccessResult(resultObj,"",userService.login(params));
    }

    /**
     * @Description: 退出
     * @Author: HuiYunfei
     * @Date: 2019/11/9
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultObj logout(@RequestBody JSONObject params) {
        ResultObj result = new ResultObj();
        try {
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


    /**
     * @Description:  未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @Author: HuiYunfei
     * @Date: 2019/11/9
     */
    @RequestMapping("/unLogin")
    public ResultObj unAuth(){
        throw new UnLoginException("用户未登录");
    }


    /**
     * @Description: 未授权，无权限，此处返回未授权状态信息由前端控制跳转页面
     * @Author: HuiYunfei
     * @Date: 2019/11/9
     */
    @RequestMapping("/unAuthorized")
    public ResultObj unauthorized() {
        throw new UnauthorizedException();
    }

}
