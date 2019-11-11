package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.entity.TPermissions;
import com.yunfei.cultural.model.dto.AddRoleParams;
import com.yunfei.cultural.model.vo.DetailRoleResult;
import com.yunfei.cultural.model.vo.ListRoleResult;
import com.yunfei.cultural.service.RoleService;
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

import java.util.List;

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
    private RoleService roleService;


    /**
     * @Description: 角色列表
     * @Author: HuiYunfei
     * @Date: 2019/11/11
     */
    @RequestMapping(value = "/listRole", method = RequestMethod.POST)
    public ResultObj listRole(){
        ResultObj resultObj = new ResultObj();
        try {
            List<ListRoleResult> list = roleService.listRole();
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            log.warn("listRole error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listRole system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description: 权限列表
     * @Author: HuiYunfei
     * @Date: 2019/11/11
     */
    @RequestMapping(value = "/listPermissions", method = RequestMethod.POST)
    public ResultObj listPermissions(){
        ResultObj resultObj = new ResultObj();
        try {
            List<TPermissions> list = roleService.listPermissions();
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            log.warn("listPermissions error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listPermissions system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }



    @RequestMapping(value = "/detailRole", method = RequestMethod.POST)
    public ResultObj detailRole(@RequestBody JSONObject params) {

        ResultObj resultObj = new ResultObj();
        try {
            if(params.getInteger("id")==null){
                throw new LogicException("角色id为空");
            }
            DetailRoleResult result=roleService.findRoleById(params.getInteger("id"));
            return ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            log.warn("detailRole error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("detailRole system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description: 保存角色
     * @Author: HuiYunfei
     * @Date: 2019/11/11
     */
    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public ResultObj saveUser(@RequestBody AddRoleParams params) {

        ResultObj resultObj = new ResultObj();
        try {
            roleService.saveRole(params);
            return ResultUtil.createSuccessResult(resultObj, "");
        } catch (LogicException e) {
            log.warn("saveRole error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("saveRole system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    @RequestMapping(value = "/delRole", method = RequestMethod.POST)
    public ResultObj delUser(@RequestBody JSONObject params) {
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getInteger("id")==null){
                throw new LogicException("角色id为空");
            }
            roleService.delRole(params.getInteger("id"));
            return ResultUtil.createSuccessResult(resultObj, "");
        } catch (LogicException e) {
            log.warn("delRole error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("delRole system error:{}",e.getMessage());
            ResultUtil.createSystemExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }


}
