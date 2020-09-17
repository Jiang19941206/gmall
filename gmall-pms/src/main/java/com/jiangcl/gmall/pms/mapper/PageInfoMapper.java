package com.jiangcl.gmall.pms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiangcl.gmall.pms.entity.SpuImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc mybatis-plus分页查询demo
 */
@Repository
public interface PageInfoMapper {

    /**
     * @desc
     * @author jiangcl
     * @date 2020/9/17
     * @param page
     * @param imgName
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.jiangcl.gmall.pms.entity.SpuImage>
     */
    IPage<SpuImage> selectSpuImages(Page<SpuImage> page, @Param("imgName")String imgName);
}
