package com.yunfei.cultural.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.mapper.TRolePermissionsMapper;
import com.yunfei.cultural.mapper.TUserRoleMapper;
import com.yunfei.cultural.model.vo.RolePermissionsModel;
import com.yunfei.cultural.model.vo.UserRoleModel;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.MySimpleByteSource;
import com.yunfei.cultural.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 自定义shiro认证赋权类
 * @Author: HuiYunfei
 * @Date: 2019/11/9
 */
@Slf4j
@Component
public class ShiroRealm extends AuthorizingRealm {

    public ShiroRealm() {
    }

    @Autowired
    @SuppressWarnings("all")
    public ShiroRealm(UserService userService,TUserRoleMapper userRoleMapper,TRolePermissionsMapper rolePermissionsMapper) {
        this.userService = userService;
        this.rolePermissionsMapper=rolePermissionsMapper;
        this.userRoleMapper=userRoleMapper;
    }


    @Resource
    private UserService userService;
    @Autowired
    private TUserRoleMapper userRoleMapper;
    @Autowired
    private TRolePermissionsMapper rolePermissionsMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        TUser user = (TUser) principals.getPrimaryPrincipal();
        //TUser user = userService.findUserByUserName(username);
        //获取用户角色
        List<UserRoleModel> userRoleList=userRoleMapper.findUserRoleByUserId(user.getId());
        if(userRoleList.size()>0){
            userRoleList.forEach(t->{
                authorizationInfo.addRole(t.getRoleMarking());
            });
        }

        //获取用户权限
        List<RolePermissionsModel> rolePermissionsList = rolePermissionsMapper.findRolePermissionsByUserId(user.getId());
        if(rolePermissionsList.size()>0){
            rolePermissionsList.forEach(t->{
                authorizationInfo.addStringPermission(t.getPermissionsMarking());
            });
        }

        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
         String username = (String) token.getPrincipal();
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        TUser user = userService.findUserByUserName(username);
        if(user==null){
            throw new UnknownAccountException();
        }
        if(user.getStatus()==1){
            throw new DisabledAccountException("账号已禁用!");
        }
        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
        if(sessions.size()>0){
            for(Session session:sessions){
                //清除该用户以前登录时保存的session
                if(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)!=null){
                    Object obj = ((SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).asList().get(0);
                    ObjectMapper objectMapper = new ObjectMapper();
                    TUser tUser = objectMapper.convertValue(obj, TUser.class);
                    if(username.equals(tUser.getUsername())) {
                        sessionManager.getSessionDAO().delete(session);
                    }
                }
            }
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                //ByteSource.Util.bytes(user.getSalt()),// md5(salt+password),采用明文访问时，不需要此句
                new MySimpleByteSource(user.getSalt()),
                getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * 将自己的验证方式加入容器
     *
     * 凭证匹配器（由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
     *
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        /**
         * 散列算法:这里可以使用MD5算法 也可以使用SHA-256
         */
        hashedCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        // 散列的次数，比如散列16次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
