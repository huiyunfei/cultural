package com.yunfei.cultural.utils.exception;


import com.yunfei.cultural.utils.result.ResultObj;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * @author http://gblfy.com
 * @Description 全局异常处理
 * @Date 2019/9/14 15:34
 * @version1.0
 */
@EnableWebMvc
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHand {


    /**
     * 401 - 未登录
     */
    @ExceptionHandler(UnLoginException.class)
    public ResultObj handleUnLoginException(UnLoginException e) {
        String msg = e.getMessage();
        log.error("登录异常：", e);
        ResultObj resultObj = new ResultObj();
        resultObj.setInfo(401);
        resultObj.setMsg(msg);
        return resultObj;
    }
    /**
     * 900 - 参数异常
     */
    @ExceptionHandler(LogicException.class)
    public ResultObj handleLogicException(LogicException e) {
        String msg =  e.getMessage();
        log.error("参数异常", e);
        ResultObj resultObj = new ResultObj();
        resultObj.setInfo(900);
        resultObj.setMsg(msg);
        return resultObj;
    }
    /**
     * 403 - 无权限
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResultObj handleLoginException(UnauthorizedException e) {
        String msg = e.getMessage();
        log.error("用户无权限：", e);
        ResultObj resultObj = new ResultObj();
        resultObj.setInfo(403);
        resultObj.setMsg("用户无权限");
        return resultObj;
    }

    /**
     * 999 - 服务器异常
     */
    @ExceptionHandler(SystemException.class)
    public ResultObj handleSysException(SystemException e) {
        String msg = "服务内部异常！" + e.getMessage();
        log.error(msg, e);
        ResultObj resultObj = new ResultObj();
        resultObj.setInfo(999);
        resultObj.setMsg(e.getMessage());
        return resultObj;
    }
    /**
     * 999 - 服务器异常
     */
    @ExceptionHandler(Exception.class)
    public ResultObj handleException(Exception e) {
        String msg = "服务内部异常！" + e.getMessage();
        log.error(msg, e);
        ResultObj resultObj = new ResultObj();
        resultObj.setInfo(999);
        resultObj.setMsg(e.getMessage());
        return resultObj;
    }

    /**
     * 处理参数绑定异常，并拼接出错的参数异常信息。
     * <p>
     * 创建人：leigq <br>
     * 创建时间：2017年10月16日 下午9:09:22 <br>
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     *
     * @param result
     */
    private String handleBindingResult(BindingResult result) {
        if (result.hasErrors()) {
            final List<FieldError> fieldErrors = result.getFieldErrors();
            return fieldErrors.iterator().next().getDefaultMessage();
        }
        return null;
    }


}
