package com.yunfei.cultural.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.constant.CommonConstants;
import com.yunfei.cultural.entity.TRole;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.entity.TUserRole;
import com.yunfei.cultural.mapper.TRoleMapper;
import com.yunfei.cultural.mapper.TUserMapper;
import com.yunfei.cultural.mapper.TUserRoleMapper;
import com.yunfei.cultural.model.dto.AddUserParams;
import com.yunfei.cultural.model.dto.ListUserParams;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.model.vo.DetailUserResult;
import com.yunfei.cultural.model.vo.ListUserResult;
import com.yunfei.cultural.model.vo.LoginResult;
import com.yunfei.cultural.model.vo.UserRoleModel;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.ShiroUtils;
import com.yunfei.cultural.utils.exception.LogicException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;
    @Autowired
    private TRoleMapper roleMapper;

    @Override
    public LoginResult login(LoginParams params) {
        LoginResult result = new LoginResult();
        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();
        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(params.getUsername(), params.getPassword());
        // 认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(token);
            // 构建缓存用户信息返回给前端
            TUser user = (TUser) currentUser.getPrincipals().getPrimaryPrincipal();
            //TUser user = this.userMapper.findByUserName(username);
            //校验当前用户是否有角色
            List<UserRoleModel> userRoleList=userRoleMapper.findUserRoleByUserId(user.getId());
            if(userRoleList.size()==0){
                throw new LogicException("用户暂无角色，不能登录");
            }
            //校验当前用户是否有权限登录到后台（是否管理员角色）
            boolean isAdmin=false;
            for (UserRoleModel userRole : userRoleList) {
                if(userRole.getRoleMarking().equals(CommonConstants.ROLE_ADMIN_MARKING)){
                    isAdmin=true;
                }
            }
            result.setIsAdmin(isAdmin);
            BeanUtils.copyProperties(user, result);
            result.setToken(currentUser.getSession().getId().toString());
            userMapper.updateByPrimaryKeySelective(TUser.builder().id(user.getId()).token(result.getToken()).build());
        }catch (UnknownAccountException e) {
            throw new LogicException("账号不存在!");
        }catch (IncorrectCredentialsException e) {
            throw new LogicException("密码错误!");
        }
        return result;
    }

    @Override
    public void logout(JSONObject params) {

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @Override
    public TUser findUserByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void updatePassword(Integer userId, String oldPassword, String newPassword) {
        TUser user = userMapper.selectByPrimaryKey(userId);
        if(user==null){
            throw new LogicException("用户不存在");
        }
        String encryOldPassword = ShiroUtils.sha256(oldPassword,user.getSalt());
        if(!user.getPassword().equals(encryOldPassword)){
            throw new LogicException("老密码错误");
        }
        if(newPassword.length()<6){
            throw new LogicException("密码长度不得小于6位数");
        }
        String encryNewPassword = ShiroUtils.sha256(newPassword, user.getSalt());
        TUser build = TUser.builder().id(userId).password(encryNewPassword).build();
        userMapper.updateByPrimaryKeySelective(build);
    }

    @Override
    public ListUserResult listUser(ListUserParams params) {
        List<ListUserResult.UserResult> userList=userMapper.findByParams(params);
        List<TRole> roles = roleMapper.selectAll();
        List<ListUserResult.RoleResult> roleList = new ArrayList<>();
        if(roles.size()>0){
            roles.forEach(t->{
                roleList.add(ListUserResult.RoleResult.builder().roleId(t.getId()).roleName(t.getRoleName()).build());
            });
        }
        return ListUserResult.builder().userList(userList).roleList(roleList).build();
    }

    @Override
    public DetailUserResult findUserById(Integer id) {
        DetailUserResult result = userMapper.findUserById(id);
        List<TRole> roles = roleMapper.selectAll();
        List<DetailUserResult.RoleResult> roleList = new ArrayList<>();
        if(roles.size()>0){
            roles.forEach(t->{
                roleList.add(DetailUserResult.RoleResult.builder().roleId(t.getId()).roleName(t.getRoleName()).build());
            });
        }
        result.setRoleList(roleList);
        return result;
    }

    @Override
    public void saveUser(AddUserParams params) {
        if(StringUtils.isBlank(params.getUsername()) || StringUtils.isBlank(params.getName())
                || params.getRoleId()==null || params.getStatus()==null){
            throw new LogicException("必填参数为空");
        }
        if(params.getId()!=null){
            //修改
            TUser user = userMapper.selectByPrimaryKey(params.getId());
            if(user==null){
                throw new LogicException("参数异常");
            }
            user.setUsername(params.getUsername());
            user.setName(params.getName());
            user.setPhone(params.getPhone());
            user.setTelephone(params.getTelephone());
            user.setEmail(params.getEmail());
            user.setStatus(params.getStatus());
            user.setUpdateTime(new Date());
            if(StringUtils.isNotBlank(params.getPassword())){
                if(!StringUtils.equals(params.getPassword(),params.getComfirmPassword())){
                    throw new LogicException("密码不一致");
                }
                String salt=user.getSalt();
                String password=ShiroUtils.sha256(params.getPassword(),salt);
                user.setPassword(password);
            }
            userMapper.updateByPrimaryKeySelective(user);
            List<UserRoleModel> userRoleList = userRoleMapper.findUserRoleByUserId(params.getId());
            if(userRoleList.size()>0){
                if(!userRoleList.get(0).getRoleId().equals(params.getRoleId())){
                    userRoleMapper.deleteByUserId(params.getId());
                    userRoleMapper.insertSelective(TUserRole.builder().userId(params.getId()).roleId(params.getRoleId()).build());
                    //清空用户redis权限信息
                    ShiroUtils.clearAllCachedAuthorizationInfo();
                    //shiroRealm.clearAllCachedAuthenticationInfo();
//                    shiroRealm.clearAllCache();
                    //ShiroUtils.reloadAuthorizing(shiroRealm,user);
//                    shiroRealm.clearCachedAuthorizationInfo(subject.getPrincipals());
//                    //认证
//                    shiroRealm.clearCachedAuthenticationInfo(subject.getPrincipals());
                }
            }
        }else{
            //新增
            if(StringUtils.isBlank(params.getPassword())|| StringUtils.isBlank(params.getComfirmPassword())){
                throw new LogicException("密码为空");
            }
            if(!StringUtils.equals(params.getPassword(),params.getComfirmPassword())){
                throw new LogicException("密码不一致");
            }
            String salt=ShiroUtils.getNextSalt();
            String password=ShiroUtils.sha256(params.getPassword(),salt);
            TUser user = TUser.builder()
                    .username(params.getUsername())
                    .password(password)
                    .salt(salt)
                    .name(params.getName())
                    .email(params.getEmail())
                    .phone(params.getPhone())
                    .telephone(params.getTelephone())
                    .createTime(new Date())
                    .build();
            userMapper.insertSelective(user);
            TUserRole userRole = TUserRole.builder().roleId(params.getRoleId()).userId(user.getId()).build();
            userRoleMapper.insertSelective(userRole);
        }
    }

    @Override
    public void delUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
        userRoleMapper.deleteByUserId(id);
        //清空用户redis权限信息
        ShiroUtils.clearAllCachedAuthorizationInfo();
    }

}














