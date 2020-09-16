package com.jiangcl.gmall.pms.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author jiangcl
 * @date 2020/9/16
 * @desc
 */
@Getter
@Setter
@ToString
public class UserInfo implements Serializable {
    private long id;
    private String loginName;
    private String nickName;
    private String passwd;
    private String name;
    private String phoneNum;
    private String email;
    private String headImg;
    private String userLevel;
}
