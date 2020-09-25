package com.jiangcl.gmall.pms.entity.es;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jiangcl
 * @date 2020/9/25
 * @desc
 */
@Getter
@Setter
public class EsUserAddress {
    private String provenceName;

    private String cityName;

    private String countyName;

    private String addressDetail;
}
