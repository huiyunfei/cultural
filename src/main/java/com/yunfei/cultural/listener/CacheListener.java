package com.yunfei.cultural.listener;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.constant.CommonConstants;
import com.yunfei.cultural.entity.TDict;
import com.yunfei.cultural.mapper.TDictMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by huiyunfei on 2019/10/20.
 */

@Component
@Slf4j
public class CacheListener  implements CommandLineRunner {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private TDictMapper dictMapper;

    @Override
    public void run(String... args) throws Exception {
        log.info("begin init dict cache");
        List<TDict> tDicts = dictMapper.selectAll();
        Map<String, List<TDict>> dictMap = tDicts.stream().collect(Collectors.groupingBy(TDict::getType));
        //String key = CommonConstants.SYSTEM_DICT_KEY;
        //redisTemplate.delete(key);
        //redisTemplate.opsForHash().putAll(key,dictMap);
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

        log.info(" init dict cache success");
    }
}
