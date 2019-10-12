package com.yunfei.cultural.utils.result;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 返回结果工具类
 * @author xuank
 *
 */
public class ResultUtil {

	/**
	 * 返回成功info值
	 */
	public final static int INFO_HTTP_SUCCESS = 100;
	
	/**
	 * 逻辑异常info值
	 */
	public final static int INFO_HTTP_LOGIC_EXCEPTION = 900;
	
	/**
	 * 系统异常info值
	 */
	public final static int INFO_HTTP_SYSTEM_EXCEPTION = 999;
	
	
	/**
	 * 
	 * @param result
	 * @param msg
	 * @param obj
	 * @param status
	 * @return
	 */
	public static ResultObj createResult(ResultObj result,String msg,Object obj,int status) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(status);
		result.setMsg(msg);
		result.setObj(obj);
		return result;
	}
	

	/**
	 *
	 * @param result
	 * @param msg
	 * @param status
	 * @return
	 */
	public static ResultObj createResult(ResultObj result,String msg,int status) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(status);
		result.setMsg(msg);
		return result;
	}

	/**
	 * HTTP协议controller接口调用成功,正常返回. 样例:{"info":0,"msg":"success","obj":null}
	 * 
	 * @return ResultObj
	 */
	public static ResultObj createSuccessResult(ResultObj result,String msg,Object obj) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(INFO_HTTP_SUCCESS);
		result.setMsg(msg);
		result.setObj(obj);
		return result;
	}
	
	/**
	 * HTTP协议controller接口调用成功,正常返回. 样例:{"info":0,"msg":"success","obj":null}
	 * 
	 * @return ResultObj
	 */
	public static ResultObj createSuccessResult(ResultObj result,String msg) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(INFO_HTTP_SUCCESS);
		result.setMsg(msg);
		return result;
	}
	
	/**
	 * HTTP协议controller接口调用逻辑异常
	 * 
	 * @return ResultObj
	 */
	public static ResultObj createLocgicExceptionResult(ResultObj result,String msg,Object obj) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(INFO_HTTP_LOGIC_EXCEPTION);
		result.setMsg(msg);
		result.setObj(obj);
		return result;
	}
	
	/**
	 * HTTP协议controller接口调用逻辑异常
	 * 
	 * @return ResultObj
	 */
	public static ResultObj createLocgicExceptionResult(ResultObj result,String msg) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(INFO_HTTP_LOGIC_EXCEPTION);
		result.setMsg(msg);
		return result;
	}
	
	/**
	 * HTTP协议controller接口调用系统异常
	 * 
	 * @return ResultObj
	 */
	public static ResultObj createSystemExceptionResult(ResultObj result,String msg,Object obj) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(INFO_HTTP_SYSTEM_EXCEPTION);
		result.setMsg(msg);
		result.setObj(obj);
		return result;
	}
	
	/**
	 * HTTP协议controller接口调用系统异常
	 * 
	 * @return ResultObj
	 */
	public static ResultObj createSystemExceptionResult(ResultObj result,String msg) {
		if(result == null) {
			result = new ResultObj();
		}
		result.setInfo(INFO_HTTP_SYSTEM_EXCEPTION);
		result.setMsg(msg);
		return result;
	}


	@SuppressWarnings("rawtypes")
	private static boolean isNull(Object obj) {
		if(obj == null) {
			return true;
		}else if(obj instanceof CharSequence) {
			return ((CharSequence) obj).length() == 0;
		}else if(obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		}else if(obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}else if(obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		return false;
	}
	
}
