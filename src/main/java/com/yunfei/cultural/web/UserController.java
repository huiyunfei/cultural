package com.yunfei.cultural.web;

import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

/**
 * @author http://gblfy.com
 * @Description 测试主方法
 * @Date 2019/9/14 15:34
 * @version1.0
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController {



    @GetMapping("list")
    @RequiresPermissions("user:list")
    public ResultObj listUser() {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj,"用户列表");
    }


    @GetMapping("{userId}")
    @RequiresPermissions("user:detail")
    public ResultObj detailUser(@PathVariable("userId") Long userId) {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj,"用户详情");
    }


    @PostMapping("add")
    @RequiresRoles("admin")
    @RequiresPermissions("user:add")
    public ResultObj addUser() {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj, "添加用户");
    }

    @DeleteMapping("del")
    @RequiresRoles("role")
    public ResultObj delUser() {
        ResultObj resultObj = new ResultObj();
        return ResultUtil.createSuccessResult(resultObj, "删除用户");
    }


}
