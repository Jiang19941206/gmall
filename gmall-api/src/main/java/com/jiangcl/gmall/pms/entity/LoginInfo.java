package com.jiangcl.gmall.pms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangcl
 * @date 2020/10/21
 * @desc
 */
@Data
public class LoginInfo implements Serializable {
    private String userName;

    private String email;

    private String accessToken;
}
