package com.jiangcl.gmall.pms.mapper;

import com.jiangcl.gmall.pms.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangcl
 * @date 2020/9/18
 * @desc
 */
@Repository
public interface GoodsCategoryMapper {
    List<GoodsCategory> goodsCategoryList(@Param("parentId") long parentId);
}
