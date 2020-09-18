package com.jiangcl.gmall.pms;
import com.google.common.collect.Lists;

import com.jiangcl.gmall.pms.entity.GoodsCategory;
import com.jiangcl.gmall.pms.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class GmallPmsApplicationTests {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        //UserInfo userInfo = userInfoService.getUserInfo();
        //System.out.println(userInfo.toString());
        userInfoService.insertUserInfo();
        System.out.println("添加成功！！！");
    }

    @Test
    public void test2(){
        GoodsCategory category = new GoodsCategory();
        category.setCategoryId(1L);
        category.setCategoryName("redis 测试");
        category.setParentId(0L);
        category.setChildrens(null);

        redisTemplate.opsForValue().set("category",category);

        Object category1 = redisTemplate.opsForValue().get("category");
        System.out.println(category1.toString());
    }

}
