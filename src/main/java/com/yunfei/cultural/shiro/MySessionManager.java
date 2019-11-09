package com.yunfei.cultural.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
/**
 *
 * @Author: http://gblfy.com
 * @Version 1.0.0
 *
 * 自定义session管理
 * <br/>
 * 传统结构项目中，shiro从cookie中读取sessionId以此来维持会话，在前后端分离的项目中（也可在移动APP项目使用），
 * 我们选择在ajax的请求头中传递sessionId，因此需要重写shiro获取sessionId的方式。
 * 自定义MySessionManager类继承DefaultWebSessionManager类，重写getSessionId方法
 */
@Slf4j
public class MySessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "token";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public MySessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            return null;//super.getSessionId(request, response);
        }
    }

 //   @Override
//    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
//        Serializable sessionId = getSessionId(sessionKey);
//
//        if (sessionId == null) {
//            return null;
//        }
//
//        ServletRequest request = WebUtils.getRequest(sessionKey);
//
//        if(request.getAttribute(MY_SESSION_ATTRIBUTE) != null){
//            log.debug("Get Session from request!");
//            return (Session)request.getAttribute(MY_SESSION_ATTRIBUTE);
//        }else{
//            log.debug("Get Session from redis!");
//            Session s = retrieveSessionFromDataSource(sessionId);
//            if (s == null) {
//                //session ID was provided, meaning one is expected to be found, but we couldn't find one:
//                String msg = "Could not find session with ID [" + sessionId + "]";
//                throw new UnknownSessionException(msg);
//            }
//            request.setAttribute(MY_SESSION_ATTRIBUTE,s);
//            return s;
//        }
//    }
}