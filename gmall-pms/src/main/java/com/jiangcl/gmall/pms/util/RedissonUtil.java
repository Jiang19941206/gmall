package com.jiangcl.gmall.pms.util;

import com.alibaba.fastjson.JSON;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangcl
 * @date 2020/11/8
 * @desc 使用redisson操作Redis
 */
@Component
public class RedissonUtil {
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 使用redisson往Redis中存入数据
     */
    public void setValue(){
        /**
         * 先从redisson中获取一个map
         * redissonClient.getMap(String key); 这个key就是我们即将存入redis的key
         */
        RMap<String, String> cart = redissonClient.getMap("cart");

        List<String> sList = new ArrayList<>();
        sList.add("a");
        sList.add("b");
        sList.add("c");
        sList.add("d");
        //使用redisson往Redis中存入数据
        String jsonStr = JSON.toJSONString(sList);
        cart.put("1",jsonStr);
    }

    public void getValue(){
        /**
         * 先从redisson中获取一个map
         * redissonClient.getMap(String key); 这个key是必须在Redis中存在的
         */
        RMap<String, String> cart = redissonClient.getMap("cart");
        String s = cart.get("1");
        System.out.println(s);
    }
}
