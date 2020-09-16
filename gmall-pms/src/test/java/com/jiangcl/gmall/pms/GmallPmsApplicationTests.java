package com.jiangcl.gmall.pms;

import com.jiangcl.gmall.pms.entity.UserInfo;
import com.jiangcl.gmall.pms.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GmallPmsApplicationTests {
    @Autowired
    private UserInfoService userInfoService;

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
}
