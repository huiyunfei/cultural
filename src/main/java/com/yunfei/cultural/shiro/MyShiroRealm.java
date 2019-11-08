package com.yunfei.cultural.shiro;

import com.yunfei.cultural.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hui.yunfei@qq.com on 2019/11/8
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    /**
     * @Description: 授权
     * @Author: HuiYunfei
     * @Date: 2019/11/8
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * @Description: 认证
     * @Author: HuiYunfei
     * @Date: 2019/11/8
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
