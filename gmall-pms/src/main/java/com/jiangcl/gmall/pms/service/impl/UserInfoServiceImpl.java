package com.jiangcl.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jiangcl.gmall.pms.entity.UserInfo;
import com.jiangcl.gmall.pms.mapper.UserInfoMapper;
import com.jiangcl.gmall.pms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiangcl
 * @date 2020/9/16
 * @desc
 */
@Service
@Component
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = userInfoMapper.selectById("1");
        return userInfo;
    }

    @Override
    public void insertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(123);
        userInfo.setLoginName("jiangcl");
        userInfo.setNickName("haha");
        userInfo.setPasswd("123456");
        userInfo.setName("jcl");
        userInfo.setPhoneNum("1234567880");
        userInfo.setEmail("123@qq.com");
        userInfo.setHeadImg("http://baidu.com");
        userInfo.setUserLevel("2");

        userInfoMapper.insertUserInfo(userInfo);
    }
}
