package com.jiangcl.gmall.pms.entity.redis;

/**
 * @author jiangcl
 * @date 2020/10/21
 * @desc
 */
public class SysRedisKey {
    //用户登录信息key
    public static final String LOGIN_USER_INFO = "login:user:";

    //用户登录超时key
    public static final Long LOGIN_USER_TIMEOUT = 30l;
}
