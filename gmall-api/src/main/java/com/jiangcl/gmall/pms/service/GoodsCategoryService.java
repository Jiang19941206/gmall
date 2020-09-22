package com.jiangcl.gmall.pms.service;

import com.jiangcl.gmall.pms.entity.GoodsCategory;

import java.util.List;

/**
 * @author jiangcl
 * @date 2020/9/18
 * @desc
 */
public interface GoodsCategoryService {

    //使用mybatis实现种类的递归查询
    List<GoodsCategory> goodsCategoryList();

    //添加数据，验证事物隔离级别
    void insertCategory();
}
