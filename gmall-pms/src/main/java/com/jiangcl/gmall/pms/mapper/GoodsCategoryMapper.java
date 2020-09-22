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
    /**
     * @desc 使用mybatis实现递归查询
     * @author jiangcl
     * @date 2020/9/21
     * @param parentId
     * @return java.util.List<com.jiangcl.gmall.pms.entity.GoodsCategory>
     */
    List<GoodsCategory> goodsCategoryList(@Param("parentId") long parentId);

    /**
     * 下面几个方法用于测试事物的隔离级别
     * @param id
     * @param name
     * @param parentId
     */
    void insertCategoryA(@Param("id") long id,@Param("name") String name,@Param("parentId") long parentId);

    void insertCategoryB(@Param("id") long id,@Param("name") String name);

    void insertCategoryC(@Param("id") long id,@Param("name") String name,@Param("parentId") long parentId);

    void insertCategoryD(@Param("id") long id,@Param("name") String name,@Param("parentId") long parentId);
}
