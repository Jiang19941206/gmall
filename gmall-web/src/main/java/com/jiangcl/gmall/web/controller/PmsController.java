package com.jiangcl.gmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jiangcl.gmall.common.entity.PageInfo;
import com.jiangcl.gmall.pms.entity.SpuImage;
import com.jiangcl.gmall.pms.service.PageInfoService;
import com.jiangcl.gmall.web.entity.UserParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc
 */
@Slf4j
@Controller
@RequestMapping("/pms")
public class PmsController {
    @Reference
    private PageInfoService pageInfoService;

    /**
     * @desc mybatis-plus分页查询demo
     * @author jiangcl
     * @date 2020/9/18
     * @param imgName
     * @param page
     * @param rowSize
     * @return com.jiangcl.gmall.common.entity.PageInfo<com.jiangcl.gmall.pms.entity.SpuImage>
     */
    @GetMapping("/spu_image/list")
    @ResponseBody
    public PageInfo<SpuImage> spuImagePages(String imgName, long page, long rowSize) {
        PageInfo<SpuImage> pageInfo = pageInfoService.pageInfo(imgName, page, rowSize);
        return pageInfo;
    }

    /**
     * @param
     * @return java.lang.String
     * @desc 使用切面校验参数
     * @author jiangcl
     * @date 2020/9/17
     */
    @PostMapping("/user/register")
    @ResponseBody
    public Object register(@Validated @RequestBody UserParam userParam, BindingResult bindingResult) {
        Map<String, Object> errorMap = new HashMap<>();
        /*
        //不使用切面方式进行参数校验，是否使用切面进行参数校验根据自身需求决定
        //获取此次参数校验的错误数量
        int errorCount = bindingResult.getErrorCount();
        //如果错误数量大于0，则根据需求进行错误逻辑处理，此处模拟返回错误信息
        if(errorCount > 0){
            errorMap.put("code",500);
            //获取出错的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(error ->{
                //验证未通过的字段
                String field = error.getField();
                //验证返回的错误信息
                String message = error.getDefaultMessage();
                errorMap.put("msg",message);
                //获取出错的字段的值
                Object value = error.getRejectedValue();
                log.info("属性：{}，接收到的值：{}，校验出错，提示信息为：{}",field,value,message);
            });
            return errorMap;
        }*/
        errorMap.put("code", 200);
        errorMap.put("msg", "success");
        //模拟异常
        //int i = 1 / 0;
        return errorMap;
    }
}
