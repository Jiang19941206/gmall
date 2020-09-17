package com.jiangcl.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiangcl.gmall.common.entity.PageInfo;
import com.jiangcl.gmall.pms.entity.SpuImage;
import com.jiangcl.gmall.pms.mapper.PageInfoMapper;
import com.jiangcl.gmall.pms.service.PageInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc mybatis-plus分页查询
 */
@Slf4j
@Component
@Service
public class PageInfoServiceImpl implements PageInfoService {
    @Autowired
    private PageInfoMapper pageInfoMapper;

    @Override
    public PageInfo<SpuImage> pageInfo(String imgName,long currentPage,long rowSize) {
        Page page = new Page<SpuImage>(currentPage,rowSize);
        IPage<SpuImage> iPage = pageInfoMapper.selectSpuImages(page, imgName);
        PageInfo<SpuImage> pageInfo = new PageInfo<>(iPage.getCurrent(), iPage.getPages(), iPage.getSize(), iPage.getTotal(), iPage.getRecords());
        log.info("查询的结果是：{}",pageInfo);
        return pageInfo;
    }
}
