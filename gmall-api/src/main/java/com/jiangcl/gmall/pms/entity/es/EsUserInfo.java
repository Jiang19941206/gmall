package com.jiangcl.gmall.pms.entity.es;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jiangcl
 * @date 2020/9/25
 * @desc
 */
@Getter
@Setter
public class EsUserInfo {
    private String name;

    private String passwd;

    private String nickName;

    private Integer age;

    private EsUserAddress address;

    private List<EsUserClass> userClasses;
}
