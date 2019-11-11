package com.yunfei.cultural.service.impl;

import com.yunfei.cultural.constant.CommonConstants;
import com.yunfei.cultural.entity.TPermissions;
import com.yunfei.cultural.entity.TRole;
import com.yunfei.cultural.entity.TRolePermissions;
import com.yunfei.cultural.entity.TUserRole;
import com.yunfei.cultural.mapper.*;
import com.yunfei.cultural.model.dto.AddRoleParams;
import com.yunfei.cultural.model.vo.DetailRoleResult;
import com.yunfei.cultural.model.vo.ListRoleResult;
import com.yunfei.cultural.model.vo.RolePermissionsModel;
import com.yunfei.cultural.service.RoleService;
import com.yunfei.cultural.shiro.ShiroRealm;
import com.yunfei.cultural.utils.StringUtils;
import com.yunfei.cultural.utils.exception.LogicException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;
    @Autowired
    private TRoleMapper roleMapper;

    @Autowired
    private TRolePermissionsMapper rolePermissionsMapper;
    @Autowired
    private TPermissionsMapper permissionsMapper;

    @Override
    public List<ListRoleResult> listRole() {
        List<ListRoleResult> roleList = new ArrayList<>();
        List<TRole> roles = roleMapper.selectAll();
        List<RolePermissionsModel> rolePermissionsList=rolePermissionsMapper.findRolePermissions();
        if(rolePermissionsList.size()>0){
            Map<Integer, List<RolePermissionsModel>> permissionsMap = rolePermissionsList.stream().collect(Collectors.groupingBy(RolePermissionsModel::getRoleId));
            if(roles.size()>0){
                roles.forEach(role->{
                    ListRoleResult roleResult = ListRoleResult.builder().roleId(role.getId()).roleName(role.getRoleName()).remark(role.getRemark()).build();
                    if(permissionsMap.get(role.getId())!=null){
                        List<RolePermissionsModel> rolePermissionsModelList = permissionsMap.get(role.getId());
                        List<String> permissionsList = new ArrayList<>();
                        rolePermissionsModelList.forEach(permissions->{
                            permissionsList.add(permissions.getPermissionsName());
                        });
                        roleResult.setPermissionsList(permissionsList);
                    }
                    roleList.add(roleResult);
                });
            }
        }
        return roleList;
    }

    @Override
    public List<TPermissions> listPermissions() {
        return permissionsMapper.selectAllByType(0);
    }

    @Override
    public void delRole(Integer id) {
        List<TUserRole> userRoleByRole = userRoleMapper.findUserRoleByRole(id);
        if(userRoleByRole.size()>0){
            throw new LogicException("该角色有用户正在使用，禁止删除");
        }
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DetailRoleResult findRoleById(Integer id) {
        TRole role = roleMapper.selectByPrimaryKey(id);
        List<TRolePermissions> rolePermissionsList=rolePermissionsMapper.selectByRoleId(id);
        List<Integer> permissionsIdList = new ArrayList<>();
        if(rolePermissionsList.size()>0){
            rolePermissionsList.forEach(t->{
                permissionsIdList.add(t.getPermissionsId());
            });
        }
        return DetailRoleResult.builder()
                .id(id)
                .roleName(role.getRoleName())
                .remark(role.getRemark())
                .permissionsId(permissionsIdList)
                .build();
    }

    @Override
    public void saveRole(AddRoleParams params) {
        if(StringUtils.isBlank(params.getRoleName()) || StringUtils.isBlank(params.getRoleMarking())
            || params.getPermissionsId()==null || params.getPermissionsId().size()<1){
            throw new LogicException("必填参数为空");
        }
        TRole build = TRole.builder()
                .roleMarking(params.getRoleMarking())
                .roleName(params.getRoleName())
                .remark(params.getRemark())
                .build();
        if(params.getId()!=null){
            //修改
            if(params.getId()==1 && !params.getRoleMarking().equals(CommonConstants.ROLE_ADMIN_MARKING)){
                throw new LogicException("管理员角色禁止修改标示");
            }
            rolePermissionsMapper.deleteByRoleId(params.getId());
        }else{
            //新增
            roleMapper.insertSelective(build);

        }
        params.getPermissionsId().forEach(t->{
            TRolePermissions rolePermissions = TRolePermissions.builder().permissionsId(t).roleId(build.getId()).build();
            rolePermissionsMapper.insertSelective(rolePermissions);
        });

        //清空redis权限和认证信息
        Subject subject = SecurityUtils.getSubject();
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        shiroRealm.clearCachedAuthorizationInfo(subject.getPrincipals());
        //认证
        shiroRealm.clearCachedAuthenticationInfo(subject.getPrincipals());

    }
}














