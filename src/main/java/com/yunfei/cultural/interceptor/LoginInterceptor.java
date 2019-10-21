package com.yunfei.cultural.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.constant.CommonConstants;
import com.yunfei.cultural.utils.StringUtils;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by hui.yunfei@qq.com on 2019/4/17
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        log.info("---------------------开始进入请求地址拦截----------------------------");
        String uri = httpServletRequest.getRequestURI();
        if(uri.endsWith("login")){
            log.info("login接口不拦截");
            return true;
        }
        if(uri.contains("/file")){
            log.info("/file接口不拦截");
            return true;
        }
        String token = httpServletRequest.getHeader("token");
        if(StringUtils.isEmpty(token)){
            return false;
        }
        String userId= (String) redisTemplate.opsForValue().get(CommonConstants.CULTURAL_USER_ACCOUNT+":"+ token);
        if(userId!=null) {
            return true;
        }
        httpServletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter pw = httpServletResponse.getWriter();
        ResultObj result=new ResultObj();
        ResultUtil.createLocgicExceptionResult(result, "当前请求未登录", null);
        pw.write(JSONObject.toJSON(result).toString());
        pw.flush();
        pw.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //log.info("---------------视图渲染之后的操作-------------------------0");
    }

}




















