package com.jiangcl.gmall.pms.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiangcl
 * @date 2020/9/18
 * @desc 商品类目
 */
@Getter
@Setter
public class GoodsCategory implements Serializable {
    private long categoryId;

    private String categoryName;

    private long parentId;

    private List<GoodsCategory> childrens;
}
