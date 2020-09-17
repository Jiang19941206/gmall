package com.jiangcl.gmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jiangcl.gmall.common.entity.PageInfo;
import com.jiangcl.gmall.pms.entity.SpuImage;
import com.jiangcl.gmall.pms.service.PageInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc
 */
@Controller
@RequestMapping("/pms")
public class PmsController {
    @Reference
    private PageInfoService pageInfoService;

    @GetMapping("/spu_image/list")
    @ResponseBody
    public PageInfo<SpuImage> spuImagePages(String imgName,long page,long rowSize){
        PageInfo<SpuImage> pageInfo = pageInfoService.pageInfo(imgName, page, rowSize);
        return pageInfo;
    }
}
