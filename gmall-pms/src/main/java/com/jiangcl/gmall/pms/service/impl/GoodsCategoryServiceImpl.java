package com.jiangcl.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jiangcl.gmall.pms.entity.GoodsCategory;
import com.jiangcl.gmall.pms.mapper.GoodsCategoryMapper;
import com.jiangcl.gmall.pms.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jiangcl
 * @date 2020/9/18
 * @desc
 */
@Service(timeout = 30000)
@Component
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> goodsCategoryList() {
        List<GoodsCategory> categories = goodsCategoryMapper.goodsCategoryList(0);
        return categories;
    }
}
