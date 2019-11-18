package com.yunfei.cultural.filter;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.utils.result.ResultObj;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hui.yunfei@qq.com on 2019/11/19
 */
public class MyPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {


    public MyPermissionsAuthorizationFilter() {
        super();
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter pw = httpServletResponse.getWriter();
        ResultObj result=new ResultObj();
        result.setInfo(403);
        result.setMsg("无权限");
        pw.write(JSONObject.toJSON(result).toString());
        pw.flush();
        pw.close();

        return false;
//        WebUtils.toHttp(response).sendError(HttpServletResponse.SC_FORBIDDEN);
//        return false;
    }

}
