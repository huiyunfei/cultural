package com.yunfei.cultural.web;

import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
        log.info("login in：{} ", params.getUsername());
        ResultObj resultObj = new ResultObj();
        try {
            if(StringUtils.isEmpty(params.getUsername()) || StringUtils.isEmpty(params.getPassword())){
                throw new LogicException("账号密码不能为空");
            }
            TUser login = userService.login(params);
            return ResultUtil.createSuccessResult(resultObj,"",login);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("login error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("login system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return null;
    }

    @RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
    public TUser findById(@PathVariable(value="id") Integer id){
        log.info("findById in：{} ",id);
        return null;
    }
}

















