package com.jiangcl.gmall.pms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc 商品图片类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpuImage implements Serializable {
    /**
     * 主键
     */
    private long id;

    /**
     * 商品ID
     */
    private long spuId;

    /**
     * 图片名称
     */
    private String imgName;

    /**
     * 图片地址
     */
    private String imgUrl;
}
