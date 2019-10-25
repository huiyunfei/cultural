package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONArray;
import com.yunfei.cultural.Application;
import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.mapper.TUserMapper;
import com.yunfei.cultural.service.UserService;
import com.yunfei.cultural.utils.DictUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hui.yunfei@qq.com on 2019/10/12
 */
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    public static final String LIFEPLUS_SHOP_DISH = "lifeplus:shop:dish";
    @Test
    public void findById() {
        TUser tUser = userMapper.selectByPrimaryKey(1);
        System.out.println(tUser);

    }
    @Test
    public void getDict() {
        String label = DictUtils.getDictLabel("0", "label", null);
        System.out.println(label);

    }

    @Test
    public void testRedis(){

        Map map = new HashMap<>();
        map.put("100", "123");
        map.put("200", "234");
        redisTemplate.boundHashOps(LIFEPLUS_SHOP_DISH).put(String.valueOf(1), map);
    }
    @Test
    public void testRedisList(){
//        List list = new ArrayList<>();
//        list.add(TUser.builder().id(1).name("yunfei").build());
//        list.add(TUser.builder().id(2).name("yunfei2").build());
//        redisTemplate.opsForValue().set(LIFEPLUS_SHOP_DISH, JSON.toJSONString(list));

        List<TUser> list2 = new ArrayList<>();
        Object dishRedis = redisTemplate.opsForValue().get(LIFEPLUS_SHOP_DISH);
        list2= JSONArray.parseArray(dishRedis.toString(),TUser.class);
        System.out.println(list2.size());
    }
}