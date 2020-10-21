package com.jiangcl.gmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jiangcl.gmall.pms.entity.LoginInfo;
import com.jiangcl.gmall.pms.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangcl
 * @date 2020/10/21
 * @desc
 */
@RestController
public class UmsController {

    @Reference
    private LoginService loginService;

    @GetMapping("/login")
    public Object login(String userName,String passwd){
        LoginInfo loginInfo = loginService.userLogin(userName, passwd);
        if(loginInfo == null){
            return "用户名或密码错误，请重新输入！！！";
        }
        return loginInfo;
    }
}
