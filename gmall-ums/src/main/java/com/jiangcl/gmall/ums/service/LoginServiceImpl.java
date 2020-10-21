package com.jiangcl.gmall.ums.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.jiangcl.gmall.pms.entity.LoginInfo;
import com.jiangcl.gmall.pms.entity.UserInfo;
import com.jiangcl.gmall.pms.entity.redis.SysRedisKey;
import com.jiangcl.gmall.pms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangcl
 * @date 2020/10/21
 * @desc
 */
@Component
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public LoginInfo userLogin(String userName, String passwd) {
        /**
         * 此处模拟登录，所以不进行数据库查询
         */
        String md5Digest = DigestUtils.md5DigestAsHex("123456".getBytes());
        String passwdMd5 = DigestUtils.md5DigestAsHex(passwd.getBytes());
        //若用户名或者密码不匹配则返回null
        if(!"zhangsan".equals(userName) || !md5Digest.equals(passwdMd5)){
            return null;
        }
        //当用户名和密码输入正确时，查询出用户信息，并保存部分信息到redis中
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("zhangsan");
        userInfo.setNickName("我来举个栗子");
        userInfo.setPhoneNum("13565495268");
        userInfo.setEmail("zhangsan@qq.com");
        userInfo.setHeadImg("http://www.baidu.com");
        userInfo.setUserLevel("12");

        String userInfoJson = JSONObject.toJSONString(userInfo);
        //使用UUID做为token
        String accessToken = UUID.randomUUID().toString().replace("-","");
        redisTemplate.opsForValue().set(SysRedisKey.LOGIN_USER_INFO + accessToken,userInfoJson,SysRedisKey.LOGIN_USER_TIMEOUT, TimeUnit.MINUTES);
        //返回信息
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUserName(userInfo.getNickName());
        loginInfo.setEmail(userInfo.getEmail());
        loginInfo.setAccessToken(accessToken);

        return loginInfo;
    }
}
