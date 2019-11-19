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
 * @Description: 登陆类
 * @Author: HuiYunfei
 * @Date: 2019/11/11
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
     * @Description:修改密码
     * @Author: HuiYunfei
     * @Date: 2019/11/11
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public ResultObj updatePassword(@RequestBody JSONObject params) {
        ResultObj resultObj = new ResultObj();
        Integer userId = params.getInteger("userId");
        String oldPassword = params.getString("oldPassword");
        String newPassword = params.getString("newPassword");
        try {
            if (userId==null || StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
                throw new LogicException("必填参数不能为空");
            }
            userService.updatePassword(userId, oldPassword, newPassword);
            resultObj.setInfo(100);
        } catch (LogicException se) {
            log.error("============/system/updatePassword:", se);
            ResultUtil.createLocgicExceptionResult(resultObj, se.getMessage());
        } catch (Exception e) {
            log.error("============/system/updatePassword:", e);
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }


}
