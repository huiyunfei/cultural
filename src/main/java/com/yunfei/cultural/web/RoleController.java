package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 后台角色管理类，拥有admin权限的可以访问
 * @Author: HuiYunfei
 * @Date: 2019/11/9
 */
@RestController
@Slf4j
@RequestMapping("/role")
@RequiresRoles("admin")
public class RoleController {

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

    @GetMapping("{userId}")
    public ResultObj detailUser(@PathVariable("userId") Long userId) {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj,"用户详情");
    }


    @PostMapping("add")
    public ResultObj addUser() {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj, "添加用户");
    }

    @DeleteMapping("del")
    public ResultObj delUser() {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj, "删除用户");
    }


}
