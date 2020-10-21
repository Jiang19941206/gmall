package com.jiangcl.gmall.pms.service;

import com.jiangcl.gmall.pms.entity.LoginInfo;

/**
 * @author jiangcl
 * @date 2020/10/21
 * @desc 登录验证
 */
public interface LoginService {
    /**
     * @desc 模拟登陆
     * @author jiangcl
     * @date 2020/10/21
     * @param userName
     * @param passwd
     * @return com.jiangcl.gmall.pms.entity.LoginInfo
     */
    LoginInfo userLogin(String userName,String passwd);
}
