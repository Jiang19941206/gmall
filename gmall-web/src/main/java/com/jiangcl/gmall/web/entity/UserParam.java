package com.jiangcl.gmall.web.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc 参数接收实体类
 */
@Getter
@Setter
@ToString
public class UserParam implements Serializable {
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    private String passwd;

    private String nickName;

    @NotNull(message = "电话不能为空")
    private long telPhone;

    @Email(message = "邮件地址不符合规范")
    private String email;
}
