/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.yunfei.cultural.utils;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.constant.CommonConstants;
import com.yunfei.cultural.entity.TDict;
import com.yunfei.cultural.mapper.TDictMapper;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 字典工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
@Component
public class DictUtils {

	private static TDictMapper dictDao;

	@Resource
	public void setTDictMapper(TDictMapper dictDao){
		DictUtils.dictDao=dictDao;
	}

	private static RedisTemplate redisTemplate;

	@Resource
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(TDict.class));
		DictUtils.redisTemplate = redisTemplate;
	}

	public static final String CACHE_DICT_MAP = "system:dict";

	public static String getDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (TDict dict :getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}

	public static String getDictLabels(String values, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getDictLabel(value, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (TDict dict : getDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}

	public static List<TDict> getDictList(String type){
		@SuppressWarnings("unchecked")
		Object obj=redisTemplate.opsForValue().get(CACHE_DICT_MAP+":"+type);
		//Object obj=redisTemplate.opsForHash().get(CACHE_DICT_MAP,type);
		if(obj!=null){
			return JSONObject.parseArray(obj.toString(), TDict.class);
		}else{
			Map<String, List<TDict>> dictMap = new HashMap<>();
			for (TDict dict : dictDao.selectAll()){
				List<TDict> dictList = dictMap.get(dict.getType());
				if (dictList != null){
					dictList.add(dict);
				}else{
					List<TDict> list = new ArrayList();
					list.add(dict);
					dictMap.put(dict.getType(), list);
				}
			}
			if(!dictMap.isEmpty()){
				for (Map.Entry<String, List<TDict>> entry : dictMap.entrySet()) {
					String key = CommonConstants.SYSTEM_DICT_KEY +":"+ entry.getKey();
					if (entry.getValue().isEmpty()) {
						redisTemplate.opsForValue().set(key, "");
					} else {
						String json = JSONObject.toJSONString(entry.getValue());
						redisTemplate.delete(key);
						redisTemplate.opsForValue().set(key, json);
						redisTemplate.expire(key, 1, TimeUnit.DAYS);
					}
				}
			}
			//redisTemplate.opsForHash().putAll(CACHE_DICT_MAP,dictMap);
			return dictMap.get(type);
		}
	}

	/**
	 * 返回字典列表（JSON）
	 * @param type
	 * @return
	 */
	public static String getDictListJson(String type){
		return JSONObject.toJSONString(getDictList(type));
	}
	
}
