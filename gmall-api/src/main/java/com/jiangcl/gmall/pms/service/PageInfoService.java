package com.jiangcl.gmall.pms.service;

import com.jiangcl.gmall.common.entity.PageInfo;
import com.jiangcl.gmall.pms.entity.SpuImage;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc mybatis-plus分页查询
 */
public interface PageInfoService {
    PageInfo<SpuImage> pageInfo(String imgName,long currentPage,long rowSize);
}
