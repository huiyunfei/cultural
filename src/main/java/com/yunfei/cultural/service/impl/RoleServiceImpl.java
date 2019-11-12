package com.yunfei.cultural.service.impl;

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
import com.yunfei.cultural.utils.ShiroUtils;
import com.yunfei.cultural.utils.StringUtils;
import com.yunfei.cultural.utils.exception.LogicException;
import lombok.extern.slf4j.Slf4j;
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
                        StringBuilder sb = new StringBuilder();
                        rolePermissionsModelList.forEach(permissions->{
                            sb.append(permissions.getPermissionsName()+",");
                        });
                        roleResult.setPermissions(sb.subSequence(0,sb.length()-1).toString());
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
        rolePermissionsMapper.deleteByRoleId(id);

        //清空用户redis权限信息
        ShiroUtils.clearAllCachedAuthorizationInfo();
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
        if(StringUtils.isBlank(params.getRoleName())
            || params.getPermissionsId()==null || params.getPermissionsId().size()<1){
            throw new LogicException("必填参数为空");
        }
        TRole build = TRole.builder()
                .roleName(params.getRoleName())
                .remark(params.getRemark())
                .build();
        if(params.getId()!=null){
            //修改
//            if(params.getId()==1 && !params.getRoleMarking().equals(CommonConstants.ROLE_ADMIN_MARKING)){
//                throw new LogicException("管理员角色禁止修改标示");
//            }
            build.setId(params.getId());
            roleMapper.updateByPrimaryKeySelective(build);
            rolePermissionsMapper.deleteByRoleId(params.getId());
            //清空用户redis权限信息
            ShiroUtils.clearAllCachedAuthorizationInfo();
        }else{
            //新增
            build.setRoleMarking(StringUtils.getRandomString(5));
            roleMapper.insertSelective(build);
        }
        params.getPermissionsId().forEach(t->{
            TRolePermissions rolePermissions = TRolePermissions.builder().permissionsId(t).roleId(build.getId()).build();
            rolePermissionsMapper.insertSelective(rolePermissions);
        });


    }
}














