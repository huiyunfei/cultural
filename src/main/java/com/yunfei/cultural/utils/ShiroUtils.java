package com.yunfei.cultural.utils;

import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.shiro.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import sun.misc.BASE64Encoder;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Shiro工具类
 */
public class ShiroUtils {
    /**  加密算法 */
    public final static String hashAlgorithmName = "SHA-256";
    /**  循环次数 */
    public final static int hashIterations = 16;

    public static String sha256(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

    // 获取一个测试账号 admin
    public static void main(String[] args) {
        // 3743a4c09a17e6f2829febd09ca54e627810001cf255ddcae9dabd288a949c4a
        String salt=getNextSalt();
        System.out.println("salt:"+salt);
        System.out.println("password:"+sha256("yunfei",salt)) ;
    }

    public static String getNextSalt() {
        Random RANDOM = new SecureRandom();
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        String str = new BASE64Encoder().encode(salt);
        return str;
    }
    /**
     * 获取会话
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }
    
    /**
     * Subject：主体，代表了当前“用户”
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 重新赋值权限(在比如:给一个角色临时添加一个权限,需要调用此方法刷新权限,否则还是没有刚赋值的权限)
     * @param myRealm 自定义的realm
     * @param username 用户名
     */
//    public static void reloadAuthorizing(ShiroRealm myRealm, String userName){
//        Subject subject = SecurityUtils.getSubject();
//        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
//        //第一个参数为用户名,第二个参数为realmName,test想要操作权限的用户
//        subject.runAs(new SimplePrincipalCollection(userName, subject.getPrincipals().getRealmNames().iterator().next()));
//        myRealm.getAuthorizationCache().remove(subject.getPrincipals());
//        subject.releaseRunAs();
//    }

    /**
     * @Description:清除所有用户的权限信息（修改用户、修改角色时调用）
     * @Author: HuiYunfei
     * @Date: 2019/11/12
     */
    public static void clearAllCachedAuthorizationInfo(){
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        shiroRealm.clearAllCachedAuthorizationInfo();
    }
    /**
     * @Description:清除所有用户的认证缓存（暂未启用认证缓存）
     * @Author: HuiYunfei
     * @Date: 2019/11/12
     */
    public static void clearAllCachedAuthenticationInfo(){
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        shiroRealm.clearAllCachedAuthorizationInfo();
    }
    public static TUser getUserEntity() {
        return (TUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static Integer getUserId() {
        return getUserEntity().getId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }
}